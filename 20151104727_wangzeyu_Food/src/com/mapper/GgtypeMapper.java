package com.mapper;

import com.model.Ggtype;
import com.model.Ggtype;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface GgtypeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ggtype
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer ggtypeId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ggtype
     *
     * @mbggenerated
     */
    int insert(Ggtype record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ggtype
     *
     * @mbggenerated
     */
    Ggtype selectByPrimaryKey(Integer ggtypeId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ggtype
     *
     * @mbggenerated
     */
    List<Ggtype> selectAll(@Param("ggtype")Ggtype record,@Param("page")int page,@Param("rows")int rows);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ggtype
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Ggtype record);
}