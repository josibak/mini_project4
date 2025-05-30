package com.example.miniprj.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 1000)
    private String description; //content

    private String coverImageUrl;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    // 추후 User와 연결 시
    // @ManyToOne
    // private User user;
}
