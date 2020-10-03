package com.codecool.videorecomandationservice.videorecomandationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class VideorecomandationserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(VideorecomandationserviceApplication.class, args);
    }

}
