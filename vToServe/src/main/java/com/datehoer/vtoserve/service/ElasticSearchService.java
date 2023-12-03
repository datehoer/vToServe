package com.datehoer.vtoserve.service;

import com.datehoer.vtoserve.model.ElasticSearch;
import org.springframework.data.elasticsearch.core.SearchHit;

import java.util.List;

public interface ElasticSearchService {
    void save(ElasticSearch elasticSearch);
    ElasticSearch findById(Integer id);
    void deleteById(Integer id);
    long count();
    boolean existsById(Integer id);
    List<SearchHit<ElasticSearch>> findByTitleOrContent(String title, String content);
}
