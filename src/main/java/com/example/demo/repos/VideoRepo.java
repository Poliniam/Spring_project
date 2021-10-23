package com.example.demo.repos;

import com.example.demo.domain.Message;
import com.example.demo.domain.Video;
import org.springframework.data.repository.CrudRepository;

public interface VideoRepo extends CrudRepository<Video, Long> {
}
