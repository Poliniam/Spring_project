package com.example.demo.domain;

import javax.persistence.*;
import java.sql.Time;
import java.util.List;

@Entity
@Table(name = "Videos")
public class Video {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String author;

    private String name;
    private String year_production;
    private Time time;
    private String description;
    private String link;
    @ManyToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="theme_id")
    private Theme theme;

    @ManyToMany
    @JoinTable(name="Account",
            joinColumns=@JoinColumn(name="video_id"),
            inverseJoinColumns=@JoinColumn(name="account_id"))
    private List<Account> accounts;

    public Video(){}

    public Video(String author, String name, String year, Time time, String description, User user){

    }

    public Video(String author, String name, String year_production, Time time, String description, Theme theme){
        this.author = author;
        //this.theme_id = theme_id;
        this.name = name;
        this.year_production = year_production;
        this.time = time;
        this.description = description;
        this.theme = theme;
    }




    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }


    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }


   /* public Integer getTheme_id() {
        return theme_id;
    }
    public void setTheme_id(Integer theme_id) {
        this.theme_id = theme_id;
    }*/


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public String getYear_production() {
        return year_production;
    }
    public void setYear_production(String year_production) {
        this.year_production = year_production;
    }


    public Time getTime() {
        return time;
    }
    public void setTime(Time time) {
        this.time = time;
    }


    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }


    public Theme getTheme() {
        return theme;
    }
    public void setTheme(Theme theme) {
        this.theme = theme;
    }


    public List<Account> getAccounts() {
        return accounts;
    }
    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
