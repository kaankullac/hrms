package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{
	List<JobAdvertisement> getByIsActiveTrue();
	
	List<JobAdvertisement> getByIsActiveTrueAndEmployerId(int employerId);
	
	List<JobAdvertisement> getByIsActiveTrueOrderByAdsPublisDate();
}
