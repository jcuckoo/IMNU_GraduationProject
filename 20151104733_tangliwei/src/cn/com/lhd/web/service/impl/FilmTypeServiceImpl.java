package cn.com.lhd.web.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;
import cn.com.lhd.web.entity.FilmType;
import cn.com.lhd.web.mapper.IFilmTypeMapper;
import cn.com.lhd.web.service.IFilmTypeService;
import cn.com.lhd.web.utils.BlankUtil;

/**
*
* @desc
* 
*/
@Service
public class FilmTypeServiceImpl implements IFilmTypeService {
	
	@Autowired
	private IFilmTypeMapper iFilmTypeMapper;

	@Override
	public List<FilmType> queryList(FilmType filmType, Set<String> fields, Set<ISort> sortSet, IPage page) {
		return iFilmTypeMapper.loads(filmType, fields, sortSet, page);
	}

	@Override
	public int queryCount(FilmType filmType) {
		return iFilmTypeMapper.loadCount(filmType);
	}

	@Override
	public FilmType queryById(Long id) {
		return iFilmTypeMapper.loadById(id);
	}

	@Override
	public boolean saveOrUpdate(FilmType filmType) {
		if (BlankUtil.isBlank(filmType.getId())) {
			return iFilmTypeMapper.insert(filmType) > 0;
		}
		return iFilmTypeMapper.update(filmType) > 0;
	}

	@Override
	public boolean delete(Long id) {
		return iFilmTypeMapper.delete(id);
	}

	@Override
	public List<FilmType> queryWithFilmCount() {
		return iFilmTypeMapper.loadWithFilmCount();
	}

}
