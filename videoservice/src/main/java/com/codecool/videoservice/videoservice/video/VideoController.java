package com.codecool.videoservice.videoservice.video;

import com.codecool.videoservice.videoservice.video.common.VideoRecommendation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/video")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class VideoController {

    private final VideoService videoService;

    @Autowired
    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @GetMapping
    public List<VideoModel> getAllMovies(){
        return videoService.getAllMovies();
    }

    @GetMapping("/{id}")
    public Optional<VideoModel> getMovie(@PathVariable int id){
        return videoService.getMovieById(id);
    }

    @GetMapping("/recommendation/{videoId}")
    public List<VideoRecommendation> getRecommendationByVideoId(@PathVariable int videoId){
        return videoService.getRecommendationByVideoId(videoId);
    }
    @PostMapping("/addRecommendation")
    public void addRecommendation(@RequestBody VideoRecommendation videoRecommendation){
        videoService.addRecommendation(videoRecommendation);
    }
}
