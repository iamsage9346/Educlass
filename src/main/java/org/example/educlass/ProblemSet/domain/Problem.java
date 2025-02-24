package org.example.educlass.ProblemSet.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.educlass.BaseTimeEntity;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "problem")
public class Problem extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ProblemType type;

    @Column(nullable = false, length = 1000)
    private String content;

    @Column(nullable = false, length = 255)
    private String answer;

    @Column(nullable = false)
    private int chapter;

    @Column(nullable = false)
    private int grade;

    @Builder
    public Problem(String content, String answer, int chapter, int grade, ProblemType type) {
        this.content = content;
        this.answer = answer;
        this.chapter = chapter;
        this.grade = grade;
        this.type = type;
    }

    public void update(String content, String answer, int chapter) {
        this.content = content;
        this.answer = answer;
        this.chapter = chapter;
    }
}
