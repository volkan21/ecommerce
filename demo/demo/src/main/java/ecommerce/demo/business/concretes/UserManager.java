package ecommerce.demo.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.demo.business.abstracts.UserService;
import ecommerce.demo.core.DataResult;
import ecommerce.demo.core.Result;
import ecommerce.demo.core.SuccessDataResult;
import ecommerce.demo.core.SuccessResult;
import ecommerce.demo.core.entities.User;
import ecommerce.demo.dataAccess.abstracts.UserDao;
@Service
public class UserManager implements UserService {
	@Autowired
	private UserDao userdao;

	@Override
	public Result add(User user) {
		// TODO Auto-generated method stub
		this.userdao.save(user);
		return new SuccessResult("Kullanici eklendi");
	}

	@Override
	public DataResult<User> findByEmail(String email) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<User>(this.userdao.findByEmail(email), "Kullanici bulundu");
	}

}
