package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Cv.Image;

public interface ImageDao extends JpaRepository<Image, Integer>{
	
	Image findByJobSeekerId(int jobSeekerId);

}
