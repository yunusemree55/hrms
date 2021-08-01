package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.ErrorResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.core.results.SuccessDataResult;
import kodlamaio.hrms.core.results.SuccessResult;
import kodlamaio.hrms.core.validationServices.mailValidation.EmailValidationService;
import kodlamaio.hrms.core.validationServices.personValidation.HrmsCheckService;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {
	
	private EmployerDao employerDao;
	private EmailValidationService emailValidationService;
	private HrmsCheckService hrmsCheckService;

	@Autowired
	public EmployerManager(EmployerDao employerDao,HrmsCheckService hrmsCheckService,EmailValidationService emailValidationService) {
		super();
		this.employerDao = employerDao;
		this.hrmsCheckService = hrmsCheckService;
		this.emailValidationService = emailValidationService;
	}
	

	@Override
	public Result add(Employer employer) {
		
		if(employer.getCompanyName().isEmpty()|| employer.getEmail().isEmpty() || employer.getPassword().isEmpty() || employer.getWebSite().isEmpty()) {
			
			return new ErrorResult("Boş alan bırakmayınız");
		}
		
		if(!this.employerDao.findByEmail(employer.getEmail()).isEmpty()) {
		
			return new ErrorResult("Girilen eposta sistemde mevcuttur");
		}
		
		if(!this.hrmsCheckService.checkIfRealPerson(employer)) {
			
			return new ErrorResult("HRMS Ekibi tarafından onay alınamadı");
		}
		if(!this.emailValidationService.verificationEmail(employer.getEmail())) {
			
			return new ErrorResult("Email doğrulaması başarısız");
		}
		
			this.employerDao.save(employer);
			return new SuccessResult("İş veren sisteme kaydedildi");
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"İş Verenler Listelendi");
	}

}
