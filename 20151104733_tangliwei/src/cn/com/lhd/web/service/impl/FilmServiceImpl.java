package cn.com.lhd.web.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;
import cn.com.lhd.web.entity.Film;
import cn.com.lhd.web.mapper.IFilmMapper;
import cn.com.lhd.web.service.IFilmService;

/**
 *
 * @desc
 *
 */
@Service
public class FilmServiceImpl implements IFilmService {
	
	@Autowired
	private IFilmMapper iFilmMapper;

	@Override
	public List<Film> queryList(Film film, Set<String> fields, Set<ISort> sortSet, IPage page) {
		return iFilmMapper.loads(film, fields, sortSet, page);
	}

	@Override
	public Film queryById(Long id) {
		return iFilmMapper.loadById(id);
	}

	@Override
	public boolean saveOrUpdate(Film film) {
		if (Objects.isNull(film.getId())) {
			return iFilmMapper.insert(film) > 0;
		}
		return iFilmMapper.update(film) > 0;
	}

	@Override
	public int queryCount(Film film) {
		return iFilmMapper.loadCount(film);
	}

	@Override
	public boolean delete(Long id) {
		return iFilmMapper.delete(id);
	}

}
