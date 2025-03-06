package org.example.educlass.exam.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.educlass.BaseTimeEntity;
import org.example.educlass.ProblemSet.domain.ProblemSet;
import org.example.educlass.member.domain.Student;

@Entity
@Table(name = "student_test")
@Getter
@Setter
@NoArgsConstructor
public class StudentTest extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lecture_id", nullable = false)
    private Lecture lecture;

    @Column(nullable = false)
    private int score; // 학생의 점수

    @Column(nullable = false)
    private boolean completed; // 응시 여부

    @Column(nullable = false)
    private int grade; // 응시 여부

    @Column(nullable = false)
    private int chapter; // 응시 여부

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "problem_set_id")
    private ProblemSet problemSet;

    @Builder
    public StudentTest(Student student, Lecture lecture, int score, boolean completed) {
        this.student = student;
        this.lecture = lecture;
        this.score = score;
        this.completed = completed;
    }
}
