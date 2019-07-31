package com.anna.projectdemo.config;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 配置文件加载类
 *
 * @author liuhy
 * @create 2019-07-31 18:05
 **/
@Configuration
public class ElasticConfig {

    @Value("${spring.data.elasticsearch.cluster-name}")
    private String clusterName;

    @Value("${spring.data.elasticsearch.cluster-nodes}")
    private String esHosts;

    private TransportClient transportClient;

    @PostConstruct
    public void initialize() throws UnknownHostException {
        Settings settings = Settings.builder()
                .put("cluster.name", clusterName)
                .build();

        transportClient = new PreBuiltTransportClient(settings);
        String[] hosts = esHosts.split(",");
        for (String host :
                hosts) {
            transportClient.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(host), 9300));
        }

    }

    @Bean
    public Client getClient() {
        return transportClient;
    }

    @Bean
    public ElasticsearchTemplate elasticsearchTemplate() {
        return new ElasticsearchTemplate(transportClient);
    }

    @PreDestroy
    public void destory(){
        if(transportClient != null){
            transportClient.close();
        }
    }
}
