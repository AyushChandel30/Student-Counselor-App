package in.ayush.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import in.ayush.binding.SearchCriteria;
import in.ayush.entity.StudentEnq;
import in.ayush.repo.StudentEnqRepo;

@Service
public class EnquiryServiceImpl implements EnquiryService {

	@Autowired
	private StudentEnqRepo srepo;

	@Override
	public boolean addEnq(StudentEnq se) {
		StudentEnq savedEnq = srepo.save(se);
		return savedEnq.getEnqId() != null;
	}
//==========================================================
	@Override
	public List<StudentEnq> getEnquiries(Integer cid, SearchCriteria sc) {

		StudentEnq enq = new StudentEnq();

		// setting cid
		enq.setCid(cid);

		// If 'classMode' is not null and not an empty string,
		// set 'classMode' property of enq with sc's 'classMode'
		if (sc.getClassMode() != null && !sc.getClassMode().equals("")) {
			enq.setClassMode(sc.getClassMode());
		}
		if (sc.getCourseName() != null && !sc.getCourseName().equals("")) {
			enq.setCourseName(sc.getCourseName());
		}
		if (sc.getEnqStatus() != null && !sc.getEnqStatus().equals("")) {
			enq.setEnqStatus(sc.getEnqStatus());
		}

		/*
		 * The Example.of(enq) method is used to indicate that the query should match
		 * entities whose properties match the non-null and non-default values of the
		 * example object (enq). In other words, it creates a query that looks for
		 * entities similar to the provided example. The Example class is primarily used
		 * in Spring Data JPA repositories to create dynamic queries based on the
		 * properties of an example object. It is particularly useful when you want to
		 * perform a query based on a subset of properties of an entity without
		 * specifying a full query manually.
		 */ Example<StudentEnq> of = Example.of(enq);

		List<StudentEnq> enquiries = srepo.findAll(of);

		return enquiries;
	}

}
