package com.example.miniprj.repository;

import com.example.miniprj.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
    // findByEmail 메서드 추가 가능
//    Optional<User> findByEmail(String email);
}
