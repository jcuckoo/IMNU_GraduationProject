package cn.com.cyxt.web.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.cyxt.web.entity.Menu;
import cn.com.cyxt.web.mapper.IMenuMapper;
import cn.com.cyxt.web.service.IMenuService;
import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;


/**
*
* @desc
* 
* @author luohaidian
* @date 2018年11月8日
* @time 下午3:05:11
*/
@Service
public class MenuServiceImpl implements IMenuService {
	
	@Autowired
	private IMenuMapper iMenuMapper;

	@Override
	public List<Menu> queryList(Menu menu, Set<String> fields, Set<ISort> sortSet, IPage page) {
		return iMenuMapper.loads(menu, fields, sortSet, page);
	}

	@Override
	public int queryCount(Menu menu) {
		return iMenuMapper.loadCount(menu);
	}

	@Override
	public Optional<Menu> queryById(Long id) {
		Menu menu = iMenuMapper.loadById(id);
		return Optional.ofNullable(menu);
	}

	@Override
	public boolean saveOrUpdate(Menu menu) {
		if (Objects.isNull(menu.getId())) {
			return iMenuMapper.insert(menu) > 0;
		}
		return iMenuMapper.update(menu) > 0;
	}

	@Override
	public boolean delete(Long id) {
		return iMenuMapper.delete(id);
	}

}
