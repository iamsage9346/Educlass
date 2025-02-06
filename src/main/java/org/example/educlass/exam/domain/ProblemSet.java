package org.example.educlass.exam.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.educlass.lecture.domain.Test;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "problem_set")
public class ProblemSet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_id", nullable = false)
    private Test test;

    @Column(nullable = false)
    private int problemCount;

    @Column(nullable = false)
    private Long chapter;

    @Column(nullable = false)
    private int score;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "problem_set_id")
    private List<Problem> problems;
}
