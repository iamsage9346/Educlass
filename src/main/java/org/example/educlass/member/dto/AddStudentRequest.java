package org.example.educlass.member.dto;

import org.example.educlass.member.domain.Student;

public class AddStudentRequest {

    private int grade;
    private int classNum;
    private int gender;

    public Student toEntity() {
        return Student.builder()
                .grade(grade)
                .classNum(classNum)
                .gender(gender)
                .build();
    }
}
