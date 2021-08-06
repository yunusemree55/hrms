package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Cv.Experience;

public interface ExperienceDao extends JpaRepository<Experience, Integer> {
	
	

}
