package film.mapper;

import film.bean.User;

/*
 * ÓÃ»§×¢²á
 */
public interface RegisterUserDao {
	
	public int RegisterByBean(User userInfo);
	
	public int updateByBean(User userInfo);
}
