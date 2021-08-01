package kodlamaio.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.validationServices.mailValidation.EmailValidationService;

@Service
public class EmailValidationManager implements EmailValidationService{

	@Override
	public boolean verificationEmail(String message) {
		System.out.println("Email doğrulaması gerçekleştirildi");
		return true;
	}

}
