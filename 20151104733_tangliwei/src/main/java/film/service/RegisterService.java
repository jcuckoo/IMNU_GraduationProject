package film.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import film.bean.User;
import film.mapper.RegisterUserDao;


/*
 * ÓÃ»§×¢²á
 */
@Service
public class RegisterService {

	@Autowired
	private RegisterUserDao registerUserDao;
	
	public int Register(User userInfo) {
		return registerUserDao.RegisterByBean(userInfo);
	}
	
	public int Update(User userInfo){
		return registerUserDao.updateByBean(userInfo);
	}
}
