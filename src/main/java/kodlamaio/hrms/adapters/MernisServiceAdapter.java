package kodlamaio.hrms.adapters;

import java.rmi.RemoteException;
import java.util.Locale;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.validationServices.personValidation.JobSeekerCheckService;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisServiceAdapter implements JobSeekerCheckService{

	@Override
	public boolean checkIfRealPerson(JobSeeker jobSeeker) {
		
		KPSPublicSoapProxy client = new KPSPublicSoapProxy();
		
		boolean result = true;
		
		try {
			result = client.TCKimlikNoDogrula(Long.parseLong(jobSeeker.getIdentityNumber()),
					jobSeeker.getFirstName().toUpperCase(new Locale("tr")),
					jobSeeker.getLastName().toUpperCase(new Locale("tr")), jobSeeker.getBirthOfYear());
		} catch (RemoteException e) {
			
			e.printStackTrace();
		}
		
		
		return result;
	}

}
