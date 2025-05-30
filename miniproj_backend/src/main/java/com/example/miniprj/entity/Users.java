package com.example.miniprj.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(length = 1000)
    private String username;   // 사용자명
    private String email;      // 이메일
    private String password;   // 암호화 예정

    // Book과의 관계 설정
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Book> book;  // 해당 사용자가 등록한 도서 목록
}
