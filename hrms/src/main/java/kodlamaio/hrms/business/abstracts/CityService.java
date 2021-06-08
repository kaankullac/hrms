package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.City;


public interface CityService {
	List<City> getAll();
	Result add(City city);
	DataResult<City> getById(int id);

}
