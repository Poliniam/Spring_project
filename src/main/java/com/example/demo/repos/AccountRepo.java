package com.example.demo.repos;

import com.example.demo.domain.Account;
import com.example.demo.domain.Message;
import com.example.demo.domain.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepo extends JpaRepository<Account, Long> {

}

