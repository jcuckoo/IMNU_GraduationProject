package cn.com.lhd.web.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;
import cn.com.lhd.web.entity.Role;
import cn.com.lhd.web.entity.User;
import cn.com.lhd.web.mapper.IUserMapper;
import cn.com.lhd.web.service.IUserService;
import cn.com.lhd.web.utils.CryptographyUtil;

/**
 * 
 * @desc
 *
 */
@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserMapper iUserMapper;

	@Override
	public User queryByUserName(String username) {
		User user = new User();
		user.setUsername(username);
		List<User> userList = iUserMapper.loads(user, null, null, null);
		if (userList.size() > 0) {
			return userList.get(0);
		}
		return null;
	}

	@Override
	public User queryById(Long id) {
		return iUserMapper.loadById(id);
	}

	@Override
	public boolean saveOrUpdate(User user) {
		if (Objects.isNull(user.getId())) {
			Role role = new Role(2L, null);
			user.setUserRole(role);
			user.setPassword(CryptographyUtil.md5(user.getPassword(), CryptographyUtil.SALT));
			return iUserMapper.insert(user) > 0;
		}
		return iUserMapper.update(user) > 0;
	}

	@Override
	public int queryCount(User user) {
		return iUserMapper.loadCount(user);
	}

	@Override
	public List<User> queryList(User user, Set<String> fields, Set<ISort> sortSet, IPage page) {
		return iUserMapper.loads(user, fields, sortSet, page);
	}

	@Override
	public boolean delete(Long id) {
		return iUserMapper.delete(id);
	}

}
