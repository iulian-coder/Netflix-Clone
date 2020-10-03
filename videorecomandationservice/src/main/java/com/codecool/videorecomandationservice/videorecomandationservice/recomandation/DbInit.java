package com.codecool.videorecomandationservice.videorecomandationservice.recomandation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DbInit {

    private final VideoRecommendationRepository videoRecommendationRepository;

    @Autowired
    public DbInit(VideoRecommendationRepository videoRecommendationRepository) {
        this.videoRecommendationRepository = videoRecommendationRepository;
    }

    @PostConstruct
    public void postConstruct(){
        VideoRecommendationModel videoRecommendationModel1 = new VideoRecommendationModel(1,5,"Foarte Buna",1);
        VideoRecommendationModel videoRecommendationModel2 = new VideoRecommendationModel(2,4,"Merita",1);
        VideoRecommendationModel videoRecommendationModel3 = new VideoRecommendationModel(3,5,"Yes",2);
        videoRecommendationRepository.save(videoRecommendationModel1);
        videoRecommendationRepository.save(videoRecommendationModel2);
        videoRecommendationRepository.save(videoRecommendationModel3);
    }
}
