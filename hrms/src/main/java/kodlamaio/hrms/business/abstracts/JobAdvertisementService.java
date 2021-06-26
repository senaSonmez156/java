package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {
	public Result add(JobAdvertisement jobAdvertisement);
	public Result delete(JobAdvertisement jobAdvertisement);
	public Result update(JobAdvertisement jobAdvertisement);
	public DataResult<List<JobAdvertisement>>  getAllByActiveJobAdverts ();
	public DataResult<List<JobAdvertisement>> getAllByReleasionDateAsc();
	public DataResult<List<JobAdvertisement>>
	getAllActiveJobAdvertisementEmployer_CompanyName(String companyName);
	

}
