package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerService {
	
	Result add(Employer employer);
	
	DataResult<List<Employer>> getAll();

}
