package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.City;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.concretes.JobAdvertisementSave;
import kodlamaio.hrms.entities.concretes.JobTitle;

@RestController
@RequestMapping("/api/jobAdvertisements")
public class JobAdvertisementsController {
	
	private JobAdvertisementService jobAdvertisementService;

	
		@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
		
		@GetMapping("/getall")
		
		public List<JobAdvertisement> getAll(){
			
			return this.jobAdvertisementService.getAll();
		}
		@PostMapping("/add")
		public Result add(@RequestBody JobAdvertisementSave jobAdvertisement) {
			return jobAdvertisementService.add(jobAdvertisement);

		}
		@GetMapping("/getAllActiveJobs")
		public DataResult<List<JobAdvertisement>> getByIsActiveTrue(){
			return this.jobAdvertisementService.getByIsActiveTrue();
		}
		
		 @GetMapping("/getAllActiveJobsByEmployer")
		 public DataResult<List<JobAdvertisement>> getByIsActiveTrueAndEmployerId(@RequestParam(value = "employerId")int employerId){
			 return this.jobAdvertisementService.getByIsActiveTrueAndEmployerId(employerId);
		 }
			@GetMapping("/getAllActiveJobsByPublishDate")
			public DataResult<List<JobAdvertisement>> getByIsActiveTrueOrderByAdsPublisDate(){
				return this.jobAdvertisementService.getByIsActiveTrueOrderByAdsPublisDate();
			}
			@GetMapping("/closeJobAdvertisement")
			public Result closeJobAd(@RequestParam(value="id") int id) {
				return this.jobAdvertisementService.closeJobAdvertisement(id);
			}
		
		
		
}
