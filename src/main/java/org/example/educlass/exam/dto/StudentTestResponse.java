package org.example.educlass.exam.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.educlass.exam.domain.StudentTest;

@Getter
@Setter
public class StudentTestResponse {

    private Long studentId;
    private Long testId;
    private Long problemSetId;
    private int grade;
    private int chapter;

    public StudentTestResponse(StudentTest studentTest) {
        this.studentId = studentTest.getId();
        this.testId = studentTest.getId();
        this.problemSetId = studentTest.getProblemSet().getId();
        this.grade = studentTest.getTest().getLecture().getGrade();
        this.chapter = studentTest.getTest().getLecture().getChapter();
    }
}
