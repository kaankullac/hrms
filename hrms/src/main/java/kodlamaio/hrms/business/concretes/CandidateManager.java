package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.abstracts.EmailVerificationService;
import kodlamaio.hrms.core.abstracts.ValidationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {
	
	private CandidateDao candidateDao;
	private ValidationService validationService;
	private EmailVerificationService emailVerificationService;
	
	
	public CandidateManager(CandidateDao candidateDao, ValidationService validationService,
			EmailVerificationService emailVerificationService) {
		super();
		this.candidateDao = candidateDao;
		this.validationService = validationService;
		this.emailVerificationService = emailVerificationService;
	}


	@Override
	public DataResult<List<Candidate>> getAll() {
		
		return new SuccessDataResult<List<Candidate>>
		(this.candidateDao.findAll(),"Data Listelendi");
				
				
	}


	@Override
	public Result add(Candidate candidate) {
		

		if(candidateDao.existsByEmail(candidate.getEmail())) {
			return new ErrorResult("kullanılmış Mail");
		}
		if(candidateDao.existsByNationalityId(candidate.getNationalityId())) {
			return new ErrorResult("kullanılmış kimlik numarası");
		}
		if(!validationService.isValidMail(candidate)) {
			return new ErrorResult("Geçerli olmayan mail formatı");
		}
		else {
			if(emailVerificationService.isEmailVerfied(candidate)) {
				this.candidateDao.save(candidate);
				return new SuccessResult("Mail onaylandı. Aday eklendi.");
			}
			
		}
		return new ErrorResult("Mail onaylanmadı");
		
	
	}

		
	}
	



