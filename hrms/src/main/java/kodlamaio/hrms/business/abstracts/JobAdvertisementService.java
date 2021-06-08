package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.concretes.JobAdvertisementSave;


public interface JobAdvertisementService {
	List<JobAdvertisement> getAll();
	
	Result add(JobAdvertisementSave jobAdvertisement);

	Result closeJobAdvertisement(int id);
	
	DataResult<List<JobAdvertisement>> getByIsActiveTrue();
	
	DataResult<List<JobAdvertisement>> getByIsActiveTrueAndEmployerId(int employerId);
	
	DataResult<List<JobAdvertisement>> getByIsActiveTrueOrderByAdsPublisDate();
	
}
