package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.concretes.Cv.Education;

public interface EducationService {
	
	DataResult<List<Education>> getAll();
	DataResult<List<Education>> getAllByJobSeekerId(int jobSeekerId);
	
	Result add(Education school);
	
	

}
