package com.datehoer.vtoserve.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 文件上传记录(OssUploadRecord)表查询条件封装对象
 *
 * @author admin
 */
@Data
public class DocumentLibraryQuery implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer pageNum = 1;

    private Integer pageSize = 10;

    private String categories;

    private String originalFileName;

    private String keywordFilterTxt;

    private String rversion;

    private String createBeginTime;

    private String createEndTime;

    private String fileType;
}
