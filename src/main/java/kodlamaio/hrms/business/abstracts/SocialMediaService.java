package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.concretes.Cv.SocialMedia;

public interface SocialMediaService {
	
	DataResult<List<SocialMedia>> getAll();
	Result add(SocialMedia socialMedia);
	
}
