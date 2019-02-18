package com.mapper;

import com.model.*;

import java.util.*;

import org.apache.ibatis.annotations.Param;;

public interface SpchuMapper {
	
	int deleteByPrimaryKey(Integer spchuId);
	
	int insert(Spchu record);
	
	Spchu selectByPrimaryKey(Integer spchuId);
	
	List<Spchu> selectAll(@Param("spchu")Spchu record,@Param("page")int page,@Param("rows")int rows,@Param("sdate")String sdate, @Param("edate")String edate);
	 
	int updateByPrimaryKey(Spchu record);

}
