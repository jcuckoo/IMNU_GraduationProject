package cn.com.lhd.web.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;
import cn.com.lhd.web.entity.Code;

/**
 * 
 * @desc 代码组接口
 *
 * @author luohaidian
 * @date 2018年11月5日
 * @time 下午8:39:28
 */
public interface ICodeService {
	
	/**
	 * 代码组列表
	 * @param code
	 * @param fields
	 * @param sortSet
	 * @param page
	 * @return
	 */
	public List<Code> queryList(Code code, Set<String> fields, Set<ISort> sortSet, IPage page);

	/**
	 * 代码组数
	 * @param code
	 * @return
	 */	public int queryCount(Code code);
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public Optional<Code> queryById(Long id);

	/**
	 * 新增/编辑代码组信息
	 * @param code
	 * @return
	 */
	public boolean saveOrUpdate(Code code);

	/**
	 * 根据id删除
	 * @param ids
	 * @return
	 */
	public boolean delete(Set<Long> ids);
	
	/**
	 * 歌曲类别归档
	 * 
	 * @return
	 */
	public List<Code> queryWithBlogCount();
	
}
