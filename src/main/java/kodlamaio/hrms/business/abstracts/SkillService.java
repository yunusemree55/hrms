package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.concretes.Cv.Skill;

public interface SkillService {
	
	DataResult<List<Skill>> getAll();
	Result add(Skill skill);
	

}
