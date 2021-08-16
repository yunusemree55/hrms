package kodlamaio.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.concretes.Cv.Image;

@RestController
@RequestMapping("/api/images")
public class ImagesController {
	
	private ImageService imageService;
	private JobSeekerService jobSeekerService;

	@Autowired
	public ImagesController(ImageService imageService, JobSeekerService jobSeekerService) {
		super();
		this.imageService = imageService;
		this.jobSeekerService = jobSeekerService;
	}


	
	@GetMapping("/getall")
	public DataResult<List<Image>> getAll(){
		
		return this.imageService.getAll();
	}
	
	@GetMapping("/findByJobSeekerId")
	public DataResult<Image> findByJobSeekerId(int jobSeekerId){
		
		return this.imageService.findByJobSeekerId(jobSeekerId);
		
	}
	
	@PostMapping("/add")
	public Result add(@RequestParam int JobSeekerId, @RequestParam MultipartFile imageFile) {
		
		JobSeeker jobSeeker = this.jobSeekerService.findById(JobSeekerId).getData();
		
		Image image = new Image();
		image.setJobSeeker(jobSeeker);
		return this.imageService.add(image, imageFile);
		
		
	}
	
	
	
}
