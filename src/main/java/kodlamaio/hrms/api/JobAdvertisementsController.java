package kodlamaio.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobAdvertisements")
public class JobAdvertisementsController {
	
	private JobAdvertisementService jobAdvertisementService;
	
	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}

	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getAll(){
		
		return this.jobAdvertisementService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
	
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	
	@GetMapping("/findByIsActiveTrue")
	public DataResult<List<JobAdvertisement>> findByIsActiveTrue(){
		
		return this.jobAdvertisementService.findByIsActiveTrue();
	}
	
	@GetMapping("/findByIsActiveTrueOrderByReleaseDateAsc")
	public DataResult<List<JobAdvertisement>> findByIsActiveTrueOrderByReleaseDateAsc(){
		
		return this.jobAdvertisementService.findByIsActiveTrueOrderByReleaseDateAsc();
	}
	
	@GetMapping("/findByIsActiveTrueOrderByReleaseDateDesc")
	public DataResult<List<JobAdvertisement>> findByIsActiveTrueOrderByReleaseDateDesc(){
		
		return this.jobAdvertisementService.findByIsActiveTrueOrderByReleaseDateDesc();
	}
	
	@GetMapping("/findByIsActiveAndEmployerId")
	public DataResult<List<JobAdvertisement>> findByIsActiveAndEmployerId(@RequestParam int employerId){
		
		return this.jobAdvertisementService.findByIsActiveAndEmployerId(employerId);
	}
}
