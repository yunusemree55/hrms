package kodlamaio.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.concretes.Cv.Resume;

@RestController
@RequestMapping("/api/resumes")
public class ResumesController {
	
	private ResumeService resumeService;

	@Autowired
	public ResumesController(ResumeService resumeService) {
		super();
		this.resumeService = resumeService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Resume resume) {
		
		return this.resumeService.add(resume);
	}
	
	@GetMapping("/findByJobSeekerId")
	public DataResult<List<Resume>> findByJobSeekerId(int id){
		
		return this.resumeService.findByJobSeekerId(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<Resume>> getAll(){
		
		return this.resumeService.getAll();
	}

}
