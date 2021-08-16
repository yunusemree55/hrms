package kodlamaio.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.concretes.Cv.Education;

@RestController
@RequestMapping("/api/schools")
public class EducationsController {

	private EducationService educationService;

	@Autowired
	public EducationsController(EducationService educationService) {
		super();
		this.educationService = educationService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Education>> getAll(){
		
		return this.educationService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Education school) {
		
		return this.educationService.add(school);
	}
	
	@GetMapping("/getallByJobSeekerId")
	public DataResult<List<Education>> getAllByJobSeekerId(@RequestParam int jobSeekerId){
		
		return this.educationService.getAllByJobSeekerId(jobSeekerId);
	}
	
	
}
