package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobtitleService;
import kodlamaio.hrms.entities.concretes.JobTitle;


@RestController
@RequestMapping("/api/jobtitles")
public class JobTitlesController {
	
	
	
	private JobtitleService jobTitleService;
	
	@Autowired
	public JobTitlesController(JobtitleService jobTitleService) {
		super();
		this.jobTitleService = jobTitleService;
	}

	@GetMapping("/getall")
	
	public List<JobTitle> getAll(){
		
		return this.jobTitleService.getAll();
	}
	

	
	
}
