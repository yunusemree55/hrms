package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {
	
	DataResult<List<JobAdvertisement>> getAll();
	
	Result add(JobAdvertisement jobAdvertisement);
	
	DataResult<List<JobAdvertisement>>  findByIsActiveTrue();
	
	DataResult<List<JobAdvertisement>> findByIsActiveTrueOrderByReleaseDateAsc();
	
	DataResult<List<JobAdvertisement>> findByIsActiveTrueOrderByReleaseDateDesc();
	
	DataResult<List<JobAdvertisement>> findByIsActiveAndEmployerId(int employerId);

}
