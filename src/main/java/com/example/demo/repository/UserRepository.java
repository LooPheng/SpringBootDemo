package com.example.demo.repository;

import com.example.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface UserRepository extends JpaRepository<User, Integer> {

    // 通过年龄查询
    List<User> findByAge(Integer age);
}
