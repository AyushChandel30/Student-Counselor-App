package in.ayush.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ayush.entity.StudentEnq;

public interface StudentEnqRepo extends JpaRepository<StudentEnq, Integer> {
	
	public List<StudentEnq> findByCid(Integer cid);

}
