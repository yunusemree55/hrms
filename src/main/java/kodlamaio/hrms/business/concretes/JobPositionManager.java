package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.ErrorResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.core.results.SuccessDataResult;
import kodlamaio.hrms.core.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {

	private JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public Result add(JobPosition jobPosition) {
		
		if(jobPosition.getName().length() <= 1) {
			return new ErrorResult("İsim uzunluğu yetersiz");
		}
		if(this.jobPositionDao.findByName(jobPosition.getName()).isEmpty() == false) {
			return new ErrorResult("Girilen iş pozisyonu zaten mevcut");
		}
		
		this.jobPositionDao.save(jobPosition);
		return new SuccessResult("İş pozisyonu eklendi"); 
		
	
		
	}


	@Override
	public DataResult<List<JobPosition>>  getAll() {
		
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(),"İş Pozisyonları Listelendi") ;
	}

}
