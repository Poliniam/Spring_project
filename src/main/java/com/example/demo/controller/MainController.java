package com.example.demo.controller;


import com.example.demo.domain.Message;
import com.example.demo.domain.Theme;
import com.example.demo.domain.Video;
import com.example.demo.repos.MessageRepo;
import com.example.demo.repos.ThemeRepo;
import com.example.demo.repos.VideoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Time;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private MessageRepo messageRepo;
    @Autowired
    private VideoRepo videoRepo;
    @Autowired
    private ThemeRepo themeRepo;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    /*@GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);
        return "main";
    }*/

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<Video> videos = videoRepo.findAll();
        model.put("videos", videos);
        return "main";
    }

  /*  @PostMapping("/main")
    public String add(@RequestParam String text, @RequestParam String tag, Map<String, Object> model) {
        Message message = new Message(text, tag);
        messageRepo.save(message);
        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);
        return "main";
    }*/


    @PostMapping("/main")
    public String add(@RequestParam Theme theme,
                      @RequestParam String author, @RequestParam String name, @RequestParam Time time, @RequestParam String year, @RequestParam String description, Map<String, Object> model

    ) {
        Video video = new Video( author, name, year, time, description, theme);
        videoRepo.save(video);
        Iterable<Video> messages = videoRepo.findAll();
        model.put("videos", messages);
        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<Message> messages;

        if (filter != null && !filter.isEmpty()) {
            messages = messageRepo.findByTag(filter);
        } else {
            messages = messageRepo.findAll();
        }

        model.put("messages", messages);

        return "main";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }


}

