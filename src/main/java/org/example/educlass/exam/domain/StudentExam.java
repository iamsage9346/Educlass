package org.example.educlass.exam.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.educlass.BaseTimeEntity;
import org.example.educlass.ProblemSet.domain.ProblemSet;
import org.example.educlass.member.domain.Student;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student_exam")
@Getter
@Setter
@NoArgsConstructor
public class StudentExam extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_lecture_id", nullable = false)
    private StudentLecture studentLecture;

    @Column
    private int score; // 학생의 점수

    @OneToMany(mappedBy = "studentExam", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StudentExamResult> studentExamResults = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private Completed completed; // 시간으로 해결해라 굳이 enum으로 하기에는 너무 적다.

    @Column(nullable = false)
    private int grade;

    @Column(nullable = false)
    private int chapter;

    // 업데이트 상황이 발생했을 때, 영향을 끼치면 안된다.

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "problem_set_id")
    private ProblemSet problemSet;

    @Builder
    public StudentExam(Student student, StudentLecture studentLecture, ProblemSet problemSet) {
        this.student = student;
        this.studentLecture = studentLecture;
        this.problemSet = problemSet;
    }
}
