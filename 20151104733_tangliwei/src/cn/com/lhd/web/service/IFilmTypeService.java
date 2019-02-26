package cn.com.lhd.web.service;

import java.util.List;
import java.util.Set;

import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;
import cn.com.lhd.web.entity.FilmType;

/**
 *
 * @desc 电影类别Service接口
 *
 */
public interface IFilmTypeService {
	
	/**
	 * 电影类别列表
	 * 
	 * @param filmType 电影类别模型
	 * @param fields 查询属性
	 * @param sortSet 排序器
	 * @param page 分页
	 * @return
	 */
	public List<FilmType> queryList(FilmType filmType, Set<String> fields, Set<ISort> sortSet, IPage page);

	/**
	 * 电影类别数
	 * 
	 * @param filmType 电影类别模型
	 * @return
	 */	public int queryCount(FilmType filmType);
	
	/**
	 * 根据id查询
	 * 
	 * @param id 电影类别Id
	 * @return
	 */
	public FilmType queryById(Long id);

	/**
	 * 新增/编辑电影类别
	 * 
	 * @param filmType 电影类别模型
	 * @return
	 */
	public boolean saveOrUpdate(FilmType filmType);

	/**
	 * 根据id删除
	 * 
	 * @param id 电影类别Id
	 * @return
	 */
	public boolean delete(Long id);
	
	/**
	 * 电影类别归档
	 * 
	 * @return
	 */
	public List<FilmType> queryWithFilmCount();
	
}
