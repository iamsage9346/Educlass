package org.example.educlass.exam.dto;

import lombok.Getter;
import org.example.educlass.exam.domain.StudentTest;
import org.example.educlass.exam.domain.Test;
import org.example.educlass.member.domain.Student;

@Getter
public class StudentTestRequest {
    private Student student;
    private Test test;
    private int score;
    private boolean completed;

    public StudentTest toEntity() {
        return StudentTest.builder()
                .student(student)
                .test(test)
                .score(score)
                .completed(completed)
                .build();
    }

}