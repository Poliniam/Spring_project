package com.example.demo.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Account")
public class Account {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @OneToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="user_id")
    private User ussere;

    @ManyToMany
    @JoinTable (name="Videos",
            joinColumns=@JoinColumn (name="account_id"),
            inverseJoinColumns=@JoinColumn(name="video_id"))
    private List<Video> videos;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }


    public User getUssere() {
        return ussere;
    }
    public void setUssere(User ussere) {
        this.ussere = ussere;
    }


    public List<Video> getVideos() {
        return videos;
    }
    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }
}

