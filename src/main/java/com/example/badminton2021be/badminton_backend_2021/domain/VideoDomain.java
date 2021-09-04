package com.example.badminton2021be.badminton_backend_2021.domain;

import javax.persistence.*;

@Entity
@Table(name = "youtube_videos_links")
public class VideoDomain {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String youtubeLink;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getYoutubeLink() {
        return youtubeLink;
    }

    public void setYoutubeLink(String youtubeLink) {
        this.youtubeLink = youtubeLink;
    }
}
