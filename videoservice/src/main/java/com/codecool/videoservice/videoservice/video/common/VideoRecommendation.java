package com.codecool.videoservice.videoservice.video.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VideoRecommendation {
    private int id;
    private int rating;
    private String comment;
    private int videoId;
}
