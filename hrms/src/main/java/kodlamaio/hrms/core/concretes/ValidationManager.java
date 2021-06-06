package kodlamaio.hrms.core.concretes;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.abstracts.ValidationService;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.SystemPersonnel;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class ValidationManager implements ValidationService {
	
	private Candidate candidate;

	@Override
	public boolean isValidMail(User user) {
		
		String regexString = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
		if (!Pattern.compile(regexString).matcher(user.getEmail()).matches()) {
			return false;
		}
		
		return true;
	}

	@Override
	public boolean isValidCandidateName(Candidate candidate) {
		if(candidate.getFirstName().length()<2 || candidate.getLastName().length()<2) {
		return false;
		}
		return true;
	}

	@Override
	public boolean isValidSystemPersonnelName(SystemPersonnel systemPersonnel) {
		if(systemPersonnel.getFirstName().length()<2 || systemPersonnel.getLastName().length()<2) {
		return false;
		}
		return true;
	}


	
	

}
