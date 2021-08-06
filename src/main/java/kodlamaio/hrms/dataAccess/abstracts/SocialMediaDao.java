package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Cv.SocialMedia;

public interface SocialMediaDao extends JpaRepository<SocialMedia, Integer> {

}
