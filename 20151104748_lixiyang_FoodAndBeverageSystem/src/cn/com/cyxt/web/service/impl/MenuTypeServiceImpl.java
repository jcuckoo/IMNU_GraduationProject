package cn.com.cyxt.web.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.cyxt.web.entity.MenuType;
import cn.com.cyxt.web.mapper.IMenuTypeMapper;
import cn.com.cyxt.web.service.IMenuTypeService;
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
public class MenuTypeServiceImpl implements IMenuTypeService {
	
	@Autowired
	private IMenuTypeMapper iMenuTypeMapper;

	@Override
	public List<MenuType> queryList(MenuType menuType, Set<String> fields, Set<ISort> sortSet, IPage page) {
		return iMenuTypeMapper.loads(menuType, fields, sortSet, page);
	}

	@Override
	public int queryCount(MenuType menuType) {
		return iMenuTypeMapper.loadCount(menuType);
	}

	@Override
	public Optional<MenuType> queryById(Long id) {
		MenuType menuType = iMenuTypeMapper.loadById(id);
		return Optional.ofNullable(menuType);
	}

	@Override
	public boolean saveOrUpdate(MenuType menuType) {
		if (Objects.isNull(menuType.getId())) {
			return iMenuTypeMapper.insert(menuType) > 0;
		}
		return iMenuTypeMapper.update(menuType) > 0;
	}

	@Override
	public boolean delete(Long id) {
		return iMenuTypeMapper.delete(id);
	}

	@Override
	public List<MenuType> queryWithMenuCount() {
		return iMenuTypeMapper.loadWithMenuCount();
	}

}
