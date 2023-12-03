package com.datehoer.vtoserve;

import com.datehoer.vtoserve.model.ElasticSearch;
import com.datehoer.vtoserve.service.ElasticSearchRepository;
import com.datehoer.vtoserve.service.ElasticSearchService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class VToServeApplicationTests {
    @Resource
    private ElasticSearchService elasticSearchService;
    @Test
    void contextLoads() {
    }
    @Test
    void testElasticSearch(){
        ElasticSearch elasticSearch = new ElasticSearch();
        elasticSearch.setId(3);
        elasticSearch.setTitle("Cool");
        elasticSearch.setContent("sewqeq");
        elasticSearch.setPrice(1.0);
        elasticSearchService.save(elasticSearch);
    }
    @Test
    void findById(){
        ElasticSearch byId = elasticSearchService.findById(1);
        System.out.println(byId);
    }
    @Test
    public void deleteById(){
        elasticSearchService.deleteById(3);

    }
    @Test
    public void count(){
        long count = elasticSearchService.count();
        System.out.println(count);
    }
    @Test
    public void existsById(){
        boolean b = elasticSearchService.existsById(1);
        System.out.println(b);
    }
    @Test
    public void findByTitleOrContent(){
        List<SearchHit<ElasticSearch>> byTitleOrContent = elasticSearchService.findByTitleOrContent("Good","hhhhhh");
        for (SearchHit<ElasticSearch> elasticSearchService : byTitleOrContent) {
            List<String> title = elasticSearchService.getHighlightField("title");
            System.out.println(title);
            List<String> content = elasticSearchService.getHighlightField("content");
            System.out.println(content);

        }
    }
}
