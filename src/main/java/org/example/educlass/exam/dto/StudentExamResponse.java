package org.example.educlass.exam.dto;

import org.example.educlass.exam.domain.StudentExam;

public class StudentExamResponse {

    private Long studentId;
    private Long problemSetId; // entity를 그대로 들어가는건 안된다, request와 response를 잘 분리하는게 좋다.
    private int chapter;
    private int grade;

    public StudentExamResponse(StudentExam studentExam) {
        this.studentId = studentExam.getId();
        this.problemSetId = studentExam.getProblemSet().getId();
        this.chapter = studentExam.getChapter();
        this.grade = studentExam.getGrade();
    }
}
