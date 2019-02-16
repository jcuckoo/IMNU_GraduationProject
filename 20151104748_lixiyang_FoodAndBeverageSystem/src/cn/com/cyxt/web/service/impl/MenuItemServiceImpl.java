package cn.com.cyxt.web.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.cyxt.web.entity.MenuItem;
import cn.com.cyxt.web.mapper.IMenuItemMapper;
import cn.com.cyxt.web.service.IMenuItemService;
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
public class MenuItemServiceImpl implements IMenuItemService {
	
	@Autowired
	private IMenuItemMapper iMenuItemMapper;

	@Override
	public List<MenuItem> queryList(MenuItem menuItem, Set<String> fields, Set<ISort> sortSet, IPage page) {
		return iMenuItemMapper.loads(menuItem, fields, sortSet, page);
	}

	@Override
	public int queryCount(MenuItem menuItem) {
		return iMenuItemMapper.loadCount(menuItem);
	}

	@Override
	public Optional<MenuItem> queryById(Long id) {
		MenuItem menuItem = iMenuItemMapper.loadById(id);
		return Optional.ofNullable(menuItem);
	}

	@Override
	public boolean saveOrUpdate(MenuItem menuItem) {
		if (Objects.isNull(menuItem.getId())) {
			return iMenuItemMapper.insert(menuItem) > 0;
		}
		return iMenuItemMapper.update(menuItem) > 0;
	}

	@Override
	public boolean delete(Long id) {
		return iMenuItemMapper.delete(id);
	}

}
