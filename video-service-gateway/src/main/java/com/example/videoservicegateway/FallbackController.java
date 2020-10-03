package com.example.videoservicegateway;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallbackController {

    @RequestMapping("/videoServiceFallBack")
    public Mono<String> videoServiceFallBack(){
        return Mono.just("Video Service is taking too long to respond or is down. Please try again later");

    }
    @RequestMapping("/videoRecommendationFallBack")
    public Mono<String> videoRecommendationFallBack(){
        return Mono.just("Video Recommendation is is taking too long to respond or is down. Please try again later");
    }

}
