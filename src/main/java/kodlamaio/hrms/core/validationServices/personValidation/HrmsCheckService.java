package kodlamaio.hrms.core.validationServices.personValidation;

import kodlamaio.hrms.entities.concretes.Employer;

public interface HrmsCheckService {
	
	boolean checkIfRealPerson(Employer employer);

}
