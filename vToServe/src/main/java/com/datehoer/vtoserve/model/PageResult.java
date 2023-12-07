package com.datehoer.vtoserve.model;

import lombok.Data;

import java.util.List;
@Data
public class PageResult<T> extends BasePaging {
    private List<T> dataList;
}
