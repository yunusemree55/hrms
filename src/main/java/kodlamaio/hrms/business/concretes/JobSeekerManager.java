package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.ErrorResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.core.results.SuccessDataResult;
import kodlamaio.hrms.core.results.SuccessResult;
import kodlamaio.hrms.core.validationServices.mailValidation.EmailValidationService;
import kodlamaio.hrms.core.validationServices.personValidation.JobSeekerCheckService;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;
	private JobSeekerCheckService jobSeekerCheckService;
	private EmailValidationService emailValidationService;
	
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao,JobSeekerCheckService jobSeekerCheckService,EmailValidationService emailValidationService) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.jobSeekerCheckService = jobSeekerCheckService;
		this.emailValidationService = emailValidationService;
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		
		if(jobSeeker.getFirstName().length()<2 || jobSeeker.getLastName().length() < 2) {
			
			return new ErrorResult("İsim ve Soyisim uzunluğu en az 2 olmalıdır");
			
		}
		if(!this.jobSeekerCheckService.checkIfRealPerson(jobSeeker)) {
			
			return new ErrorResult("MERNIS Doğrulaması Başarısız");
			
		}
		if(jobSeeker.getPassword().length()<6) {
			
			return new ErrorResult("Şifre uzunluğu en az 6 karakter olmalıdır");
		}
		if(!this.jobSeekerDao.findByEmail(jobSeeker.getEmail()).isEmpty()) {
			
			return new ErrorResult("Girilen email sistemde kayıtlı");
		}
		if(!this.jobSeekerDao.findByIdentityNumber(jobSeeker.getIdentityNumber()).isEmpty()) {
			
			return new ErrorResult("Girilen TC Kimlik numarası sistemde kayıtlı");
		}
		
		if(this.emailValidationService.verificationEmail(jobSeeker.getEmail())== true) {
			
			this.jobSeekerDao.save(jobSeeker);
			return new SuccessResult("Sisteme kaydedildi"); 
		}
		
		return new ErrorResult();
		
		
	}

	

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(),"İş Arayanlar Listelendi");
	}

}
