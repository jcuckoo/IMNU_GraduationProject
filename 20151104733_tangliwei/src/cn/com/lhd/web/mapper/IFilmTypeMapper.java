package cn.com.lhd.web.mapper;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;
import cn.com.lhd.web.entity.FilmType;

/**
 *
 * @desc
 *
 */
@Mapper
@Repository
public interface IFilmTypeMapper {

	/**
	 * 查询电影类别列表
	 * 
	 * @param filmType
	 * @param fields
	 * @param sortSet
	 * @param page
	 * @return
	 */
	public List<FilmType> loads(@Param("filmType") FilmType filmType, @Param("fields") Set<String> fields,
			@Param("sorts") Set<ISort> sortSet, @Param("page") IPage page);

	/**
	 * 查询电影类别列表数
	 * 
	 * @param filmType
	 * @return
	 */
	public int loadCount(@Param("filmType") FilmType filmType);

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	public FilmType loadById(@Param("id") Long id);

	/**
	 * 新增电影类别
	 * 
	 * @param filmType
	 * @return
	 */
	public int insert(@Param("filmType") FilmType filmType);

	/**
	 * 编辑电影类别
	 * 
	 * @param filmType
	 * @return
	 */
	public int update(@Param("filmType") FilmType filmType);

	/**
	 * 根据id删除电影类别
	 * 
	 * @param id
	 * @return
	 */
	public boolean delete(@Param("id") Long id);

	/**
	 * 电影类别归档
	 * 
	 * @return
	 */
	public List<FilmType> loadWithFilmCount();

}
