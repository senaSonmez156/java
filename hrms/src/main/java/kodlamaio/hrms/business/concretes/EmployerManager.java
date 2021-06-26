package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Employer;
@Service
public class EmployerManager implements EmployerService {
	

	EmployerDao employerDao;
	UserDao userDao;
	
	

	public EmployerManager(EmployerDao employerDao, UserDao userDao) {
		super();
		this.employerDao = employerDao;
		this.userDao = userDao;
		
	}

	
	

	private boolean validationForEmployer (Employer employer) {
		if(Objects.isNull(employer.getCompanyName())||
				Objects.isNull(employer.getPhoneNumber())||
				Objects.isNull(employer.getEmail())||
				Objects.isNull(employer.getPassword())||
				Objects.isNull(employer.getPhoneNumber())||
				Objects.isNull(employer.getWebAdress()))
		{return false;}
		return true;
	}
	
	
	
	
	
	
	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"Veriler listelendi.");
	}

	@Override
	public Result add(Employer employer) {
		if(!validationForEmployer(employer)) {
			return new ErrorResult("Hiçbir lan boş geçilemez.");}
		
		this.employerDao.save(employer);
		return new SuccessResult("İşveren bşarıyla kaydedildi.");
				
				
		
	
	}

	@Override
	public Result update(Employer employer) {
		this.employerDao.save(employer);
		return new SuccessResult("İşveren güncellendi.");
		
	}

	@Override
	public Result delete(Employer employer) {
	this.employerDao.delete(employer);
	return new SuccessResult("İşveren silindi.");
	}

	@Override
	public DataResult<Employer> findByEmail(String eMail) {
		return new SuccessDataResult<Employer>(this.employerDao.findByEmail(eMail));
	}
	

}
