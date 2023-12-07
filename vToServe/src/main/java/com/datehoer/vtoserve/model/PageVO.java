package com.datehoer.vtoserve.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PageVO<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 总记录数
     */
    private Long total;

    /**
     * 当前页
     */
    private Integer pageNum;

    /**
     * 每页的数量
     */
    private Integer pageSize;

    /**
     * 结果集
     */
    private List<T> rows;

    /**
     * 总页数
     */
    private Integer pages;
}
