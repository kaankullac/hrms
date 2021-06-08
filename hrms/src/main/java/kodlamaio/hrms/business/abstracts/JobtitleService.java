package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobTitle;

public interface JobtitleService {
	List<JobTitle> getAll();
	Result add(JobTitle jobTitle);
	DataResult<JobTitle> getById(int id);
	
}
