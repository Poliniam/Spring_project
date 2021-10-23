package com.example.demo.domain;


import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="Theme")
public class Theme {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String theme;

    @OneToMany (mappedBy="theme", fetch=FetchType.EAGER)
    private Collection<Video> videos;

    public Theme(){}

    public Theme(String theme){
        this.theme = theme;
    }


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }


    public String getTheme() {
        return theme;
    }
    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Collection<Video> getVideos() {
        return videos;
    }

    public void setVideos(Collection<Video> videos) {
        this.videos = videos;
    }
}

