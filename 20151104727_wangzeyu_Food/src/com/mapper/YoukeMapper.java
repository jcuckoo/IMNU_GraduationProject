package com.mapper;

import com.model.Youke;
import com.model.Youke;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface YoukeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_youke
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer youkeId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_youke
     *
     * @mbggenerated
     */
    int insert(Youke record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_youke
     *
     * @mbggenerated
     */
    Youke selectByPrimaryKey(Integer youkeId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_youke
     *
     * @mbggenerated
     */
    List<Youke> selectAll(@Param("youke")Youke record,@Param("youkeName")String youkeName,@Param("page")int page,@Param("rows")int rows, @Param("sdate")String sdate, @Param("edate")String edate);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_youke
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Youke record);
}