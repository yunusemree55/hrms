package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.concretes.Cv.Language;

public interface LanguageService {
	
	Result add(Language language);
	DataResult<List<Language>> getAll();

}
