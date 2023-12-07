package com.datehoer.vtoserve.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Document(indexName="v2ex_msg")
@Data
public class ElasticSearch {
    @Id
    @Field(store = true,index = false,type = FieldType.Integer)
    private Integer id;
    @Field(store = true, type = FieldType.Keyword)
    private String article_id;
    @Field(store = true, type = FieldType.Keyword)
    private String attachment_count;
    @Field(store = true, type = FieldType.Keyword)
    private String board;
    @Field(store = true, type = FieldType.Keyword)
    private String click_count;
    @Field(store = true, type = FieldType.Keyword)
    private String comment_count;
    @Field(store = true, type = FieldType.Text)
    private String content;
    @Field(store = true, type = FieldType.Date)
    private Date insert_time;
    @Field(store = true, type = FieldType.Date)
    private Date publish_time;
    @Field(store = true, type = FieldType.Keyword)
    private String save_count;
    @Field(store = true, type = FieldType.Text)
    private String title;
    @Field(store = true, type = FieldType.Keyword)
    private String uid;
    @Field(store = true, type = FieldType.Date)
    private Date update_time;
    @Field(store = true, type = FieldType.Keyword)
    private String user_name;
}
