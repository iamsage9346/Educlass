package org.example.educlass.lecture.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "lecture")
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 1000)
    private String link;

    @Column(nullable = false)
    private int progress;

    @Column(nullable = false)
    private int chapter;

    @Column(nullable = false)
    private int grade;

    @OneToMany(mappedBy = "lecture", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Test> tests;

    @Builder
    public Lecture(String name, String link, int chapter, int grade) {
        this.name = name;
        this.chapter = chapter;
        this.link = link;
        this.grade = grade;
    }

    public void update(String name, String link, int chapter, int grade) {
        this.name = name;
        this.link = link;
        this.chapter = chapter;
        this.grade = grade;
    }

}
