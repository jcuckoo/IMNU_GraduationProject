package cn.com.lhd.web.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;
import cn.com.lhd.web.entity.Insurance;
import cn.com.lhd.web.mapper.IInsuranceMapper;
import cn.com.lhd.web.service.IInsuranceService;
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
public class InsuranceServiceImpl implements IInsuranceService {
	
	@Autowired
	private IInsuranceMapper iInsuranceMapper;
	
	@Override
	public List<Insurance> queryList(Insurance insurance, Set<String> fields, Set<ISort> sortSet, IPage page) {
		return iInsuranceMapper.loads(insurance, fields, sortSet, page);
	}

	@Override
	public int queryCount(Insurance insurance) {
		return iInsuranceMapper.loadCount(insurance);
	}

	@Override
	public Insurance queryById(Long id) {
		return iInsuranceMapper.loadById(id);
	}

	@Override
	public boolean saveOrUpdate(Insurance insurance) {
		if (BlankUtil.isBlank(insurance.getId())) {
			return iInsuranceMapper.insert(insurance) > 0;
		}
		return iInsuranceMapper.update(insurance) > 0;
	}

	@Override
	public boolean delete(Long id) {
		return iInsuranceMapper.delete(id);
	}

}
