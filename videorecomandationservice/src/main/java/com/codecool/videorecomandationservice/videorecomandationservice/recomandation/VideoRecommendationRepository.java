package com.codecool.videorecomandationservice.videorecomandationservice.recomandation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoRecommendationRepository extends JpaRepository<VideoRecommendationModel,Integer> {
    List<VideoRecommendationModel> findAllByVideoId(int videoId);
}
