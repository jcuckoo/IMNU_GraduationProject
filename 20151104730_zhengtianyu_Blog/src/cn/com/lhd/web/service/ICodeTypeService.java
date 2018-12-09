package cn.com.lhd.web.service;

import java.util.List;
import java.util.Set;

import cn.com.lhd.core.ISort;
import cn.com.lhd.web.entity.CodeType;

/**
 * 
 * @desc 代码组类别接口
 *
 * @author luohaidian
 * @date 2018年11月5日
 * @time 下午8:39:41
 */
public interface ICodeTypeService {
	
	/**
	 * 代码组列表
	 * @param code
	 * @param fields
	 * @param sortSet
	 * @param page
	 * @return
	 */
	public List<CodeType> queryList(CodeType codeType, Set<ISort> sortSet);

}
