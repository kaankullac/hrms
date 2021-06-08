package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.business.abstracts.JobtitleService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.concretes.JobAdvertisementSave;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	
	private JobAdvertisementDao jobAdvertisementDao;
	private CityService cityService;
	private JobtitleService jobTitleService;
	private EmployerService employerService;
	
	

	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao, CityService cityService,
			JobtitleService jobTitleService, EmployerService employerService) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.cityService = cityService;
		this.jobTitleService = jobTitleService;
		this.employerService = employerService;
	}



	@Override
	public Result add(JobAdvertisementSave jobAdvertisement) {
		JobAdvertisement newJobAdvertisement = new JobAdvertisement();
		newJobAdvertisement.setActive(true);
		newJobAdvertisement.setAdsPublisDate(jobAdvertisement.getAdsPublishDate());
		newJobAdvertisement.setApplicationDate(jobAdvertisement.getApplicationDate());
		newJobAdvertisement.setCity(cityService.getById(jobAdvertisement.getCityId()).getData());
		newJobAdvertisement.setEmployer(employerService.getById(jobAdvertisement.getEmployerId()).getData());
		newJobAdvertisement.setJobTitle(jobTitleService.getById(jobAdvertisement.getJobTitleId()).getData());
		newJobAdvertisement.setJobDescription(jobAdvertisement.getJobDescription());
		newJobAdvertisement.setMaxSalary(jobAdvertisement.getMaxSalary());
		newJobAdvertisement.setMinSalary(jobAdvertisement.getMinSalary());
		newJobAdvertisement.setNumberOfPosition(jobAdvertisement.getNumberOfPosition());
		
		jobAdvertisementDao.save(newJobAdvertisement);
		 
		return new SuccessResult("İş ilanı eklendi.");
		
		
	}

	@Override
	public List<JobAdvertisement> getAll() {
		return this.jobAdvertisementDao.findAll();
	}

	@Override
	public Result closeJobAdvertisement(int id) {
		JobAdvertisement jobAdvertisement= jobAdvertisementDao.getById(id);
		jobAdvertisement.setActive(false);
		jobAdvertisementDao.save(jobAdvertisement);
	return new SuccessResult("İlan kapatıldı.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveTrue() {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.getByIsActiveTrue());
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveTrueAndEmployerId(int employerId) {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.getByIsActiveTrueAndEmployerId(employerId));
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveTrueOrderByAdsPublisDate() {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.getByIsActiveTrueOrderByAdsPublisDate());
	}

}
