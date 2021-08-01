package kodlamaio.hrms.adapters;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.validationServices.personValidation.HrmsCheckService;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class HrmsServiceAdapter implements HrmsCheckService {

	@Override
	public boolean checkIfRealPerson(Employer employer) {
		
		System.out.println("HRMS Ekibi Tarafından Onaylandı");
		return true;
	}

}
