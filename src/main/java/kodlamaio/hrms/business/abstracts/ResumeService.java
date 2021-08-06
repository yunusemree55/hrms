package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.concretes.Cv.Resume;

public interface ResumeService {
	
	DataResult<List<Resume>> getAll();
	DataResult<List<Resume>> findByJobSeekerId(int id);
	Result add(Resume resume);

}
