package org.example.educlass.exam.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.educlass.ProblemSet.domain.Problem;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class StudentExamResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_exam_id", nullable = false)
    private StudentExam studentExam;

    @ManyToOne
    @JoinColumn(name = "problem_id", nullable = false)
    private Problem problem;

    private String studentAnswer;

    private Boolean isCorrect;

    // 서술형 문제 채점용 점수 (관리자가 채점할 때 사용)
    private Integer manualScore;
}
