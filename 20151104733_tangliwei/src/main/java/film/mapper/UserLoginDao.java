package film.mapper;

import java.util.List;

import film.bean.User;

/*
 * �û���¼
 */
public interface UserLoginDao {

	public List<User> getUserLoginByBean(User userInfo);
	
}
