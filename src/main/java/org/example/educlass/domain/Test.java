package org.example.educlass.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "test")
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // 시험번호 (PK)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lecture_id", nullable = false)
    private Lecture lecture;

    @Column(nullable = false)
    private LocalDateTime initime;

    @Column(nullable = false)
    private LocalDateTime finaltime;

    @Column(nullable = false)
    private int problemCount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private YesNo status;

    @OneToMany(mappedBy = "test", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProblemSet> problemSets;
}
