package com.datehoer.vtoserve.service.impl;

import com.datehoer.vtoserve.model.DocumentLibraryQuery;
import com.datehoer.vtoserve.model.ElasticSearch;
import com.datehoer.vtoserve.model.PageResult;
import com.datehoer.vtoserve.model.PageVO;
import com.datehoer.vtoserve.service.ElasticSearchRepository;
import com.datehoer.vtoserve.service.ElasticSearchService;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortBuilders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ElasticSearchServiceImpl implements ElasticSearchService {
    @Resource
    private ElasticSearchRepository elasticSearchRepository;
    @Resource
    private ElasticsearchRestTemplate elasticsearchRestTemplate;
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
    @Override
    public PageVO<ElasticSearch> search(DocumentLibraryQuery query) {
        PageVO<ElasticSearch> pageVO = new PageVO<>();
        if(query.getPageNum() == null || query.getPageNum().equals(0)){
            query.setPageNum(1);
        }
        if(query.getPageSize() == null || query.getPageSize().equals(0)){
            query.setPageSize(10);
        }
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        nativeSearchQueryBuilder.withFilter(boolQueryBuilder);
        nativeSearchQueryBuilder.withSort(SortBuilders.fieldSort("_id"));
        nativeSearchQueryBuilder.withPageable(PageRequest.of(query.getPageNum()-1, query.getPageSize()));
        NativeSearchQuery nativeSearchQuery = nativeSearchQueryBuilder.build();
        nativeSearchQuery.addFields("_id", "article_id", "attachment_count", "board", "click_count", "comment_count", "content", "insert_time", "publish_time", "save_count", "title", "uid", "update_time", "user_name");
        SearchHits<ElasticSearch> searchHit = elasticsearchRestTemplate.search(nativeSearchQuery, ElasticSearch.class);
        if (searchHit.getTotalHits() > 0) {
            List<ElasticSearch> searchProductList = searchHit.stream().map(SearchHit::getContent).collect(java.util.stream.Collectors.toList());
            pageVO.setPageNum(query.getPageNum());
            pageVO.setPageSize(query.getPageSize());
            pageVO.setTotal(searchHit.getTotalHits());
            pageVO.setRows(searchProductList);
            pageVO.setPages((int) Math.ceil((double) searchHit.getTotalHits() / query.getPageSize()));
        }
        return pageVO;
    }
}
