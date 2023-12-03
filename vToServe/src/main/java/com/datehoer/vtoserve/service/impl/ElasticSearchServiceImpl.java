package com.datehoer.vtoserve.service.impl;

import com.datehoer.vtoserve.model.ElasticSearch;
import com.datehoer.vtoserve.service.ElasticSearchRepository;
import com.datehoer.vtoserve.service.ElasticSearchService;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ElasticSearchServiceImpl implements ElasticSearchService {
    @Resource
    private ElasticSearchRepository elasticSearchRepository;

    @Override
    public void save(ElasticSearch elasticSearch) {
        elasticSearchRepository.save(elasticSearch);
    }

    @Override
    public ElasticSearch findById(Integer id) {
        return elasticSearchRepository.findById(id).orElse(new ElasticSearch());
    }

    @Override
    public void deleteById(Integer id) {
        elasticSearchRepository.deleteById(id);
    }

    @Override
    public long count() {
        return elasticSearchRepository.count();
    }

    @Override
    public boolean existsById(Integer id) {
        return elasticSearchRepository.existsById(id);
    }

    @Override
    public List<SearchHit<ElasticSearch>> findByTitleOrContent(String title, String content) {
        return elasticSearchRepository.findByTitleOrContent(title, content);
    }
}
