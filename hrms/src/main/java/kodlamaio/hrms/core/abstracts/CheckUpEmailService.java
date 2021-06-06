package kodlamaio.hrms.core.abstracts;

import kodlamaio.hrms.entities.concretes.User;

public interface CheckUpEmailService {
	boolean check(User user);
}
