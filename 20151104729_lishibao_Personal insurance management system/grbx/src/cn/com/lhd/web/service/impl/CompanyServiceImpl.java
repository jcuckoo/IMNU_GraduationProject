package cn.com.lhd.web.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;
import cn.com.lhd.web.entity.Company;
import cn.com.lhd.web.mapper.ICompanyMapper;
import cn.com.lhd.web.service.ICompanyService;

/**
 * 
 * @desc
 *
 * @author luohaidian
 * @date 2018年12月20日
 * @time 下午8:55:47
 */
@Service
public class CompanyServiceImpl implements ICompanyService {
	
	@Autowired
	private ICompanyMapper iCompanyMapper;

	@Override
	public List<Company> queryList(Company company, Set<String> fields, Set<ISort> sortSet, IPage page) {
		return iCompanyMapper.loads(company, fields, sortSet, page);
	}

	@Override
	public int queryCount(Company company) {
		return iCompanyMapper.loadCount(company);
	}

	@Override
	public Company queryById(Long id) {
		return iCompanyMapper.loadById(id);
	}

	@Override
	public boolean saveOrUpdate(Company company) {
		if (Objects.isNull(company.getId())) {
			return iCompanyMapper.insert(company) > 0;
		}
		return iCompanyMapper.update(company) > 0;
	}

	@Override
	public boolean delete(Long id) {
		return iCompanyMapper.delete(id);
	}

}
