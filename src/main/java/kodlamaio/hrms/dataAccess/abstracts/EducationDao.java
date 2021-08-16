package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Cv.Education;

public interface EducationDao extends JpaRepository<Education, Integer> {

	Education findById(int id);
	
	List<Education> findAllByJobSeekerId(int jobSeekerId);
	
}
