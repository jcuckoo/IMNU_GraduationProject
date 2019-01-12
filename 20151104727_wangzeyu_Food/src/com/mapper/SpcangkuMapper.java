package com.mapper;

import com.model.Spcangku;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SpcangkuMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_spcangku
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer spcangkuId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_spcangku
     *
     * @mbggenerated
     */
    int insert(Spcangku record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_spcangku
     *
     * @mbggenerated
     */
    Spcangku selectByPrimaryKey(Integer spcangkuId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_spcangku
     *
     * @mbggenerated
     */
    List<Spcangku> selectAll(@Param("spcangku")Spcangku record,@Param("page")int page,@Param("rows")int rows, @Param("sdate")String sdate, @Param("edate")String edate);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_spcangku
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Spcangku record);
}