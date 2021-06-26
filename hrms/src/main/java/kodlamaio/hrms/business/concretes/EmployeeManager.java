package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hrms.entities.concretes.Employee;
@Service
public class EmployeeManager implements EmployeeService{
	
	EmployeeDao employeeDao;
	
	

	public EmployeeManager(EmployeeDao employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}

	private boolean validationForEmployee(Employee employee) {
		
		if(Objects.isNull(employee.getFirstName())||
				Objects.isNull(employee.getLastName())||
				Objects.isNull(employee.getEmail())||
				Objects.isNull(employee.getPassword()))
		{
			return false;
		}
		return true;
	}
	@Override
	public DataResult<List<Employee>> getAll() {
		
		return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll());
	}

	@Override
	public DataResult<Employee> getByEmail(String eMail) {
	
		return new SuccessDataResult<Employee>(this.employeeDao.getByEmail(eMail));
	}

	@Override
	public Result add(Employee employee) 
	{if(getByEmail(employee.getEmail()).getData() !=null) {
		return new ErrorResult("Bu eposta adresi mevcut");}
	else if(!validationForEmployee(employee)) {
		return new ErrorResult("Eksik bilgi girişi lütfen kontrol ediniz.");
		}
	this.employeeDao.save(employee);
	return new SuccessResult("başarıyla eklendi");
	
		
		
	}
}


