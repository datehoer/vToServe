package com.datehoer.vtoserve.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName="test")
@Data
public class ElasticSearch {
    @Id
    @Field(store = true,index = false,type = FieldType.Integer)
    private Integer id;
    @Field(store = true,index = true,type = FieldType.Text)
    private String title;
    @Field(store = true,index = true,type = FieldType.Text)
    private String content;
    @Field(store = true,index = true,type = FieldType.Double)
    private Double price;
}
