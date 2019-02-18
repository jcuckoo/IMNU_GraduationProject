package cn.com.cyxt.web.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.cyxt.web.entity.Order;
import cn.com.cyxt.web.mapper.IOrderMapper;
import cn.com.cyxt.web.service.IOrderService;
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
public class OrderServiceImpl implements IOrderService {
	
	@Autowired
	private IOrderMapper iOrderMapper;

	@Override
	public List<Order> queryList(Order order, Set<String> fields, Set<ISort> sortSet, IPage page) {
		return iOrderMapper.loads(order, fields, sortSet, page);
	}

	@Override
	public int queryCount(Order order) {
		return iOrderMapper.loadCount(order);
	}

	@Override
	public Optional<Order> queryById(Long id) {
		Order order = iOrderMapper.loadById(id);
		return Optional.ofNullable(order);
	}

	@Override
	public boolean save(Order order) {
		return iOrderMapper.insert(order) > 0;
	}

	@Override
	public boolean delete(Long id) {
		return iOrderMapper.delete(id);
	}

}
