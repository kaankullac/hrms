package kodlamaio.hrms.core.abstracts;

import kodlamaio.hrms.entities.concretes.User;

public interface EmailVerificationService {
	boolean isEmailVerfied(User user);

}
