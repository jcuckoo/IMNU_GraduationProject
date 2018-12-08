package cn.com.lhd.core;

/**
 * 分页接口
 */
public interface IPage {

    Integer getPageNo();//页码

    Integer getPageSize();//页容量

    int getTotalRecord();//总计数

    void setTotalRecord(int totalRecord);

}
