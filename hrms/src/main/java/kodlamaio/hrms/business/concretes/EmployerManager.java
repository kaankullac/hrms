package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.abstracts.EmailVerificationService;
import kodlamaio.hrms.core.abstracts.ValidationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {
	
	private EmployerDao employerDao;
	private EmailVerificationService emailVerificationService;
	private ValidationService validationService;

	@Autowired
	public EmployerManager(EmployerDao employerDao, EmailVerificationService emailVerificationService,
			ValidationService validationService) {
		super();
		this.employerDao = employerDao;
		this.emailVerificationService = emailVerificationService;
		this.validationService = validationService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>
		(this.employerDao.findAll(),"Data Listelendi");
	}

	@Override
	public Result add(Employer employer) {
		if(employerDao.existsByEmail(employer.getEmail())) {
			return new ErrorResult("kullanılmış Mail");
		}
		if(!validationService.isValidMail(employer)) {
			return new ErrorResult("Gerçerli olmayan mail formatı");
		}
		else {
			if(emailVerificationService.isEmailVerfied(employer)) {
				this.employerDao.save(employer);
				return new SuccessResult("Mail onaylandı. Şirket kaydedildi.");
			}
		}
		return new ErrorResult("Mail onaylanmadı");
		

	}

	@Override
	public DataResult<Employer> getById(int id) {
		return new SuccessDataResult<Employer>(employerDao.getById(id));
	}

}
