package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.core.results.SuccessDataResult;
import kodlamaio.hrms.core.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {

		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(),"Data Listelendi");
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("İş İlanı Kaydedildi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> findByIsActiveTrue() {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByIsActiveTrue(),"Aktif iş ilanları listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> findByIsActiveTrueOrderByReleaseDateAsc() {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByIsActiveTrueOrderByReleaseDateAsc(),"Aktif iş ilanları tarihe göre listelendi");
	}
	
	@Override
	public DataResult<List<JobAdvertisement>> findByIsActiveTrueOrderByReleaseDateDesc() {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByIsActiveTrueOrderByReleaseDateDesc(),"Aktif iş ilanları tarihe göre listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> findByIsActiveAndEmployerId(int employerId) {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByIsActiveAndEmployer_Id(employerId),"İşverene ait aktif iş ilanları listelendi");
	}

	
}
