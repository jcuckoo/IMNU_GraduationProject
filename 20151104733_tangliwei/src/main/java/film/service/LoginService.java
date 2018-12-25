package film.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import film.bean.User;
import film.mapper.UserLoginDao;



@Service
public class LoginService {
	
	@Autowired
	private UserLoginDao userloginDao;
	
	public List<User> Login(User userInfo){
		
		return userloginDao.getUserLoginByBean(userInfo);
	}
	
}
