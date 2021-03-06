package kodlamaio.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SocialMediaService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.concretes.Cv.SocialMedia;

@RestController
@RequestMapping("/api/socialmedias")
public class SocialMediasController {
	
	private SocialMediaService socialMediaService;

	@Autowired
	public SocialMediasController(SocialMediaService socialMediaService) {
		super();
		this.socialMediaService = socialMediaService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<SocialMedia>> getAll(){
		
		return this.socialMediaService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody SocialMedia socialMedia) {
		
		return this.socialMediaService.add(socialMedia);
		
	}
	
	
}
