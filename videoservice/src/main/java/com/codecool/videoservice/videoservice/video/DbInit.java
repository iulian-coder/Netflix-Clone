package com.codecool.videoservice.videoservice.video;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DbInit {

    private final VideoRepository videoRepository;

    @Autowired
    public DbInit(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @PostConstruct
    private void postConstruct(){
        VideoModel videoModel1 = new VideoModel (1,"The Croods: A New Age","https://youtu.be/a-o8xbEcuSY","http://img.youtube.com/vi/a-o8xbEcuSY/0.jpg");
        VideoModel videoModel2 = new VideoModel(2,"The Opening Act","https://youtu.be/WsRP_PFY-aI","http://img.youtube.com/vi/WsRP_PFY-aI/0.jpg");
        VideoModel videoModel3 = new VideoModel(  3,"No Time to Die","https://youtu.be/Ty-81sq05Gs","http://img.youtube.com/vi/Ty-81sq05Gs/0.jpg");
        VideoModel videoModel4 = new VideoModel( 4,"Fast And Furious 9","https://youtu.be/e6wKl22ph4A","http://img.youtube.com/vi/e6wKl22ph4A/0.jpg");
        videoRepository.save(videoModel1);
        videoRepository.save(videoModel2);
        videoRepository.save(videoModel3);
        videoRepository.save(videoModel4);

    }
}
