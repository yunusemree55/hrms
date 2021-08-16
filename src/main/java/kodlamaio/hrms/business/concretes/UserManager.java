package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.dataAccess.UserDao;
import kodlamaio.hrms.core.entities.User;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.core.results.SuccessDataResult;
import kodlamaio.hrms.core.results.SuccessResult;

@Service
public class UserManager implements UserService {
	
	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<User>> getAll() {
		
		return new SuccessDataResult<List<User>>(this.userDao.findAll(),"Kullanıcılar listelendi");
	}

	@Override
	public DataResult<List<User>> findByEmail(String email) {
		
		return new SuccessDataResult<List<User>>(this.userDao.findByEmail(email),"Kullanıcı listelendi");
	}

	@Override
	public Result add(User user) {
		
		this.userDao.save(user);
		return new SuccessResult("Kullanıcı eklendi");
	}

}
