package com.codecool.videorecomandationservice.videorecomandationservice.recomandation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/recommendation")
public class VideoRecommendationController {

    private final VideoRecommendationService recommendationService;

    @Autowired
    public VideoRecommendationController(VideoRecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @GetMapping("/{videoId}")
    public List<VideoRecommendationModel> getAllRecommendationByVideoId(@PathVariable int videoId){
        return recommendationService.findAllByVideoId(videoId);
    }
    @PostMapping
    public void saveRecommendation(@RequestBody VideoRecommendationModel videoRecommendationModel){
        recommendationService.saveRecommendation(videoRecommendationModel);
    }

}
