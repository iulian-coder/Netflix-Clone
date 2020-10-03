package com.codecool.videoservice.videoservice.video;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="VIDEO_TB")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoModel {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private  String url;
    private String image;

}
