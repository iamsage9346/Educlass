package org.example.educlass.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "problem")
public class Problem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 1000)
    private String content;

    @Column(nullable = false, length = 255)
    private String answer;

    @Column(nullable = false)
    private int chapter;

    @Column(nullable = false)
    private LocalDateTime addDate;

    @Column(nullable = false)
    private LocalDateTime updateDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private YesNo isUsed;
}
