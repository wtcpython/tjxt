package com.tianji.search.config;

import jakarta.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticSearchConfig {

    @Resource
    private ElasticsearchProperties elasticsearchProperties;

    @Bean
    public RestHighLevelClient restClient() {
        String uri = CollectionUtils.get(this.elasticsearchProperties.getUris(), 0);
        return new RestHighLevelClient(RestClient.builder(HttpHost.create(uri)));
    }
}
