package film.mapper;

import java.util.List;

import film.bean.User;

/*
 * ÓÃ»§µÇÂ¼
 */
public interface UserLoginDao {

	public List<User> getUserLoginByBean(User userInfo);
	
}
