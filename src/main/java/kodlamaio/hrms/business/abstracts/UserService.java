package kodlamaio.hrms.business.abstracts;



import java.util.List;

import kodlamaio.hrms.core.entities.User;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;

public interface UserService {

	DataResult<List<User>> getAll();
	DataResult<List<User>> findByEmail(String email);
	Result add(User user);
}
