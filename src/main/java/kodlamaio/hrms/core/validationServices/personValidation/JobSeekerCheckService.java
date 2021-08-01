package kodlamaio.hrms.core.validationServices.personValidation;

import kodlamaio.hrms.entities.concretes.JobSeeker;

public interface JobSeekerCheckService {

	boolean checkIfRealPerson(JobSeeker jobSeeker);
}
