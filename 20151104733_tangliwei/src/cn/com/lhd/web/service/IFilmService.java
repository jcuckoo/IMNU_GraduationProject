package cn.com.lhd.web.service;

import java.util.List;
import java.util.Set;

import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;
import cn.com.lhd.web.entity.Film;

/**
 * 
 * @desc 电影Service接口
 *
 */
public interface IFilmService {
	
	/**
	 * 查询电影列表
	 * 
	 * @param film
	 * @param fields
	 * @param sortSet
	 * @param page
	 * @return
	 */
	public List<Film> queryList(Film film, Set<String> fields, Set<ISort> sortSet, IPage page);
	
	/**
	 * 电影列表数
	 * 
	 * @param film 电影模型
	 * @return
	 */
	public int queryCount(Film film);
	
	/**
	 * 根据Id查询
	 * @param id
	 * @return
	 */
	public Film queryById(Long id);

	/**
	 * 新增/编辑
	 * @param film
	 * @return
	 */
	public boolean saveOrUpdate(Film film);

	/**
	 * 根据Id删除
	 * 
	 * @param id 电影Id
	 * @return
	 */
	public boolean delete(Long id);

}
