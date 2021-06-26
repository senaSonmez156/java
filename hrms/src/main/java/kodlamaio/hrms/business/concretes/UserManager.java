package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.User;
@Service
public class UserManager implements UserService{
	
	UserDao userDao;

	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(this.userDao.findAll(),"Kullancılar listelendi.");
	}

	@Override
	public DataResult<User> findByEmail(String email) {
	return new SuccessDataResult<User>(this.userDao.findByEmail(email),"Kullanıcı bulundu.");
	}

	@Override
	public DataResult<User> getById(int id) {
	return new SuccessDataResult<User>(this.userDao.getById(id),"Kullanıcı bulundu.");
	}

	@Override
	public Result add(User user) {
		userDao.save(user);
		return new SuccessResult ("Kullanıcı başarıyla eklendi.");
		
	}

	


	

}
