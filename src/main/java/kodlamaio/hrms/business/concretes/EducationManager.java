package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.core.results.SuccessDataResult;
import kodlamaio.hrms.core.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EducationDao;
import kodlamaio.hrms.entities.concretes.Cv.Education;

@Service
public class EducationManager implements EducationService {
	
	private EducationDao educationDao;

	@Autowired
	public EducationManager(EducationDao educationDao) {
		super();
		this.educationDao = educationDao;
	}

	@Override
	public DataResult<List<Education>> getAll() {
		
		return new SuccessDataResult<List<Education>>(this.educationDao.findAll(),"Okullar listelendi");
	}

	@Override
	public Result add(Education school) {
		
		this.educationDao.save(school);
		return new SuccessResult("Okul eklendi");
	}

	@Override
	public DataResult<List<Education>> getAllByJobSeekerId(int jobSeekerId) {
		
		return new SuccessDataResult<List<Education>>(this.educationDao.findAllByJobSeekerId(jobSeekerId));
	} 

}
