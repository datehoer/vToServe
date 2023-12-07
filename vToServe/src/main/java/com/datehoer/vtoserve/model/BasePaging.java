package com.datehoer.vtoserve.model;

import lombok.Data;

@Data
public class BasePaging {
    private int pageIndex; //当前页码
    private int pageSize; //分页大小
    private int totalData; //数据总数
    private int totalPage; //总页数
    private String orderBy; //排序
    private int offset; //偏移量
    private String indexName; //索引名称

    public int getOffset()
    {
        int offset = 0;
        if(this.pageIndex>0 && this.pageSize>0)
        {
            offset = (this.pageIndex-1)*this.pageSize;
        }
        return offset;
    }

    //计算总页数：总页数 = (数据总数 + 分页大小 -1) / 分页大小
    public int getTotalPage()
    {
        int totalPage = 0;
        if (this.totalData > 0 && this.pageSize > 0)
        {
            totalPage = (this.totalData + this.pageSize - 1) / this.pageSize;
        }
        return totalPage;
    }
}
