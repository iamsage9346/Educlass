package org.example.educlass.exam.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.educlass.ProblemSet.domain.ProblemSet;
import org.example.educlass.exam.domain.StudentTest;

@Getter
@Setter
public class StudentTestResponse {

    private Long studentId;
    private ProblemSet problemSet;
    private int chapter;
    private int grade;

    public StudentTestResponse(StudentTest studentTest) {
        this.studentId = studentTest.getId();
        this.problemSet = studentTest.getProblemSet();
        this.chapter = studentTest.getChapter();
        this.grade = studentTest.getGrade();
    }
}
