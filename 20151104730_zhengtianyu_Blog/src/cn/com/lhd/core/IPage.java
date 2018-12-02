package cn.com.lhd.core;

/**
 * 分页接口
 *
 * @author luohaidian
 * @date 2018年7月13日
 * @time 下午1:39:45
 */
public interface IPage {

    Integer getPageNo();//页码

    Integer getPageSize();//页容量

    int getTotalRecord();//总计数

    void setTotalRecord(int totalRecord);

}
