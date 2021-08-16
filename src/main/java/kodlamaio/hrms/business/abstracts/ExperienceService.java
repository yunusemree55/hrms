package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.concretes.Cv.Experience;

public interface ExperienceService {
	
	DataResult<List<Experience>> getAll();
	Result add(Experience experience);

}
