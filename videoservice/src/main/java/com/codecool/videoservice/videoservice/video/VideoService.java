package com.codecool.videoservice.videoservice.video;


import com.codecool.videoservice.videoservice.video.common.VideoRecommendation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class VideoService {

    private final VideoRepository videoRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public VideoService(VideoRepository videoRepository, RestTemplate restTemplate) {
        this.videoRepository = videoRepository;
        this.restTemplate = restTemplate;
    }

    public List<VideoModel> getAllMovies() {
        return videoRepository.findAll();
    }

    public Optional<VideoModel> getMovieById(int Id){
        return videoRepository.findById(Id);
    }

    public List<VideoRecommendation> getRecommendationByVideoId(int videoId) {
        String uri = "http://VIDEO-RECOMMENDATION/api/v1/recommendation/" + videoId;
        try {
            ResponseEntity<List<VideoRecommendation>> response = restTemplate.exchange(
                    uri,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<VideoRecommendation>>() {
                    });
            if (response.hasBody()) {
               return response.getBody();

            }
        } catch (RestClientException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void addRecommendation(VideoRecommendation videoRecommendation) {
        String uri = "http://VIDEO-RECOMMENDATION/api/v1/recommendation/";
        restTemplate.postForObject(uri, videoRecommendation, VideoRecommendation.class);
    }
}
