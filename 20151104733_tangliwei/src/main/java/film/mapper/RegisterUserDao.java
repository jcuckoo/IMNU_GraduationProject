package film.mapper;

import film.bean.User;

/*
 * �û�ע��
 */
public interface RegisterUserDao {
	
	public int RegisterByBean(User userInfo);
	
	public int updateByBean(User userInfo);
}
