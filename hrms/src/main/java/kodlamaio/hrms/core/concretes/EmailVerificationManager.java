package kodlamaio.hrms.core.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.abstracts.EmailVerificationService;
import kodlamaio.hrms.entities.concretes.User;
@Service
public class EmailVerificationManager implements EmailVerificationService{

	@Override
	public boolean isEmailVerfied(User user) {
		// simülasyon
		return true;
	}

}
