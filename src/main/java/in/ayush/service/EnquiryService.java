package in.ayush.service;

import java.util.List;

import in.ayush.binding.SearchCriteria;
import in.ayush.entity.StudentEnq;

public interface EnquiryService {
	
	public boolean addEnq(StudentEnq se);

	public List<StudentEnq> getEnquiries(Integer cid, SearchCriteria s);

}
