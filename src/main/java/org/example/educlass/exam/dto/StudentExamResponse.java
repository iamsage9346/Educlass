package org.example.educlass.exam.dto;

import lombok.Getter;
import org.example.educlass.exam.domain.StudentExam;

@Getter
public class StudentExamResponse {
    private Long id;
    private Long studentId;
    private Long problemSetId;
    private int chapter;
    private int grade;

    public StudentExamResponse(StudentExam studentExam) {
        this.id = studentExam.getId();
        this.studentId = studentExam.getId();
        this.problemSetId = studentExam.getProblemSet().getId();
        this.chapter = studentExam.getChapter();
        this.grade = studentExam.getGrade();
    }
}
