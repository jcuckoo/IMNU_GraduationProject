package cn.com.lhd.web.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import cn.com.lhd.core.IPage;
import cn.com.lhd.core.ISort;
import cn.com.lhd.web.entity.Photo;

/**
 * 
 * @desc
 *
 * @author luohaidian
 * @date 2018年11月6日
 * @time 下午9:02:07
 */
public interface IPhotoService {
	
	
	/**
	 * 查询相册列表
	 * 
	 * @param photo
	 * @param fields
	 * @param sortSet
	 * @param page
	 * @return
	 */
	public List<Photo> queryList(Photo photo, Set<String> fields, Set<ISort> sortSet, IPage page);
	
	/**
	 * 查询相册列表数
	 * 
	 * @param photo
	 * @return
	 */
	public int queryCount(Photo photo);
	
	/**
	 * 根据Id查询
	 * @param id
	 * @return
	 */
	public Optional<Photo> queryById(Long id);

	/**
	 * 新增/编辑
	 * @param photo
	 * @return
	 */
	public boolean saveOrUpdate(Photo photo);

	/**
	 * 删除相册
	 * @param ids
	 * @return
	 */
	public boolean delete(Set<Long> ids);

}
