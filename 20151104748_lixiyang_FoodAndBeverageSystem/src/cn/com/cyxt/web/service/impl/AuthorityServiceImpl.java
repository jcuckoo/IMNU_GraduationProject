package cn.com.cyxt.web.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.cyxt.web.entity.Authority;
import cn.com.cyxt.web.mapper.IAuthorityMapper;
import cn.com.cyxt.web.service.IAuthorityService;
import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;


/**
 * 
 * @desc
 *
 * @author luohaidian
 * @date 2018年11月5日
 * @time 下午8:40:25
 */
@Service
public class AuthorityServiceImpl implements IAuthorityService {
	
	@Autowired
	private IAuthorityMapper iAuthorityMapper;

	@Override
	public List<Authority> queryList(Authority authority, Set<String> fields, Set<ISort> sortSet, IPage page) {
		return iAuthorityMapper.loads(authority, fields, sortSet, page);
	}

	@Override
	public int queryCount(Authority authority) {
		return iAuthorityMapper.loadCount(authority);
	}

	@Override
	public Authority queryById(Long id) {
		return iAuthorityMapper.loadById(id);
	}

}
