package com.anna.projectdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@EnableElasticsearchRepositories(basePackages = "com.anna.projectdemo")
@SpringBootApplication
public class ProjectdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectdemoApplication.class, args);
    }

}
