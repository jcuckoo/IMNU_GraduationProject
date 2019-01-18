package cn.com.lhd.web.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;
import cn.com.lhd.web.entity.Order;
import cn.com.lhd.web.mapper.IOrderMapper;
import cn.com.lhd.web.service.IOrderService;
import cn.com.lhd.web.utils.BlankUtil;

/**
 * 
 * @desc
 *
 * @author luohaidian
 * @date 2018年12月20日
 * @time 下午8:55:55
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
	public Order queryById(Long id) {
		return iOrderMapper.loadById(id);
	}

	@Override
	public boolean saveOrUpdate(Order order) {
		if (BlankUtil.isBlank(order.getId())) {
			return iOrderMapper.insert(order) > 0;
		}
		return iOrderMapper.update(order) > 0;
	}

	@Override
	public boolean delete(Long id) {
		return iOrderMapper.delete(id);
	}

}
