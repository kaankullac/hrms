package kodlamaio.hrms.core.concretes;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.abstracts.CheckUpEmailService;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.User;
@Service
public class CheckUpEmailManager implements CheckUpEmailService {

	
	private UserDao userDao;
	
	@Autowired
	public CheckUpEmailManager(UserDao userDao) {
		super();
		this.userDao = userDao;
		
	}
	
	@Override
	public boolean check(User user) {

		
		for(User test :userDao.findAll()) {
			if(user.getEmail().equals(test.getEmail())) {
				System.out.println("Kullanılmış e mail");
				return false;
			}
			
			
		}
		
		return true;
	}
	
}
