package com.example.demo.repos;


import com.example.demo.domain.Theme;
import com.example.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThemeRepo extends JpaRepository<Theme, Long> {
}

