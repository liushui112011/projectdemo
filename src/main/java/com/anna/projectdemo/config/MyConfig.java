package com.anna.projectdemo.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 配置文件加载类
 *
 * @author liuhy
 * @create 2019-07-31 18:05
 **/
@Configuration
public class MyConfig implements InitializingBean {
    private static MyConfig myConfig = null;

    public static MyConfig getMyConfig() {
        return myConfig;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        myConfig = this;
    }

    //conf
    @Value("${spring.data.elasticsearch.cluster-name}")
    private String clusterName;



    @Bean
    public TransportClient client() throws UnknownHostException {
        Settings settings = Settings.builder()
                .put("cluster.name", "ES")
                .build();

        PreBuiltTransportClient client = new PreBuiltTransportClient(settings);
        InetSocketTransportAddress address = new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300);
        TransportClient transportClient = client.addTransportAddress(address);
        return transportClient;
    }

    public static void setMyConfig(MyConfig myConfig) {
        MyConfig.myConfig = myConfig;
    }

    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }
}
