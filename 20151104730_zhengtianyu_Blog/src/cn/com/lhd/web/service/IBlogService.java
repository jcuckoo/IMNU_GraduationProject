package cn.com.lhd.web.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;
import cn.com.lhd.web.entity.Blog;

/**
 * 
 * @desc
 *
 * @author luohaidian
 * @date 2018年11月5日
 * @time 下午9:02:07
 */
public interface IBlogService {
	
	
	/**
	 * 查询博客列表
	 * 
	 * @param blog
	 * @param fields
	 * @param sortSet
	 * @param page
	 * @return
	 */
	public List<Blog> queryList(Blog blog, Set<String> fields, Set<ISort> sortSet, IPage page);
	
	/**
	 * 查询博客列表数
	 * 
	 * @param blog
	 * @return
	 */
	public int queryCount(Blog blog);
	
	/**
	 * 根据Id查询
	 * @param id
	 * @return
	 */
	public Optional<Blog> queryById(Long id);

	/**
	 * 新增/编辑
	 * @param blog
	 * @return
	 */
	public boolean saveOrUpdate(Blog blog);

	/**
	 * 删除博客
	 * @param ids
	 * @return
	 */
	public boolean delete(Set<Long> ids);

}
