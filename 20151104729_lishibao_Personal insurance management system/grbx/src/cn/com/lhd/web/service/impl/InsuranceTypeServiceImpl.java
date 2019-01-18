package cn.com.lhd.web.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;
import cn.com.lhd.web.entity.InsuranceType;
import cn.com.lhd.web.mapper.IInsuranceTypeMapper;
import cn.com.lhd.web.service.IInsuranceTypeService;
import cn.com.lhd.web.utils.BlankUtil;

/**
 *
 * @desc
 *
 * @author luohaidian
 * @date 2018年12月21日
 * @time 上午9:50:23
 */
@Service
public class InsuranceTypeServiceImpl implements IInsuranceTypeService {
	
	@Autowired
	private IInsuranceTypeMapper iInsuranceTypeMapper;

	@Override
	public List<InsuranceType> queryList(InsuranceType insuranceType, Set<ISort> sortSet, IPage page) {
		return iInsuranceTypeMapper.loads(insuranceType, sortSet, page);
	}

	@Override
	public int queryCount(InsuranceType insuranceType) {
		return iInsuranceTypeMapper.loadCount(insuranceType);
	}

	@Override
	public InsuranceType queryById(Long id) {
		return iInsuranceTypeMapper.loadById(id);
	}

	@Override
	public boolean saveOrUpdate(InsuranceType insuranceType) {
		if (BlankUtil.isBlank(insuranceType.getId())) {
			return iInsuranceTypeMapper.insert(insuranceType) > 0;
		}
		return iInsuranceTypeMapper.update(insuranceType) > 0;
	}

	@Override
	public boolean delete(Long id) {
		return iInsuranceTypeMapper.delete(id) > 0;
	}

}
