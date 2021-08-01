package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
	
	
	List<JobAdvertisement> findByIsActiveTrue();
	
	List<JobAdvertisement> findByIsActiveTrueOrderByReleaseDateAsc();
	
	List<JobAdvertisement> findByIsActiveTrueOrderByReleaseDateDesc();
	
	@Query("From JobAdvertisement where isActive = true and employer_id = :employerId")
	List<JobAdvertisement> findByIsActiveAndEmployer_Id(int employerId);

}
