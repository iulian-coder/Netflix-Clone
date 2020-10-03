package com.codecool.videorecomandationservice.videorecomandationservice.recomandation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RECOMMENDATION_TB")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoRecommendationModel {

    @Id
    @GeneratedValue
    private int id;
    private int rating;
    private String comment;
    private int videoId;



}
