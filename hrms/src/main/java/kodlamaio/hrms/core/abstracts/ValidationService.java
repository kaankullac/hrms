package kodlamaio.hrms.core.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.SystemPersonnel;
import kodlamaio.hrms.entities.concretes.User;

public interface ValidationService {
	boolean isValidMail(User user);
	boolean isValidCandidateName(Candidate candidate);
	boolean isValidSystemPersonnelName(SystemPersonnel systemPersonnel);
	
	
}
