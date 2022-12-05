package ecommerce.demo.business.abstracts;

import ecommerce.demo.core.DataResult;
import ecommerce.demo.core.Result;
import ecommerce.demo.core.entities.User;

public interface UserService {
	Result add(User user);
	DataResult<User>findByEmail(String email);
	
	

}
