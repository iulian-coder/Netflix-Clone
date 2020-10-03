package com.codecool.videorecomandationservice.videorecomandationservice.recomandation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;

@Service
public class VideoRecommendationService {

    private final VideoRecommendationRepository videoRecommendationRepository;

    @Autowired
    public VideoRecommendationService(VideoRecommendationRepository videoRecommendationRepository) {
        this.videoRecommendationRepository = videoRecommendationRepository;
    }

    public List<VideoRecommendationModel> findAllByVideoId(int videoId){
       return videoRecommendationRepository.findAllByVideoId(videoId);
    }

    public Optional<VideoRecommendationModel> findById( int id){
        return videoRecommendationRepository.findById(id);
    }

    public void saveRecommendation(VideoRecommendationModel videoRecommendationModel) {
        videoRecommendationRepository.save(videoRecommendationModel);
    }
}
