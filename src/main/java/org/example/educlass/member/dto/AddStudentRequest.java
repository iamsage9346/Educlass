package org.example.educlass.member.dto;

import org.example.educlass.member.domain.Student;

public class AddStudentRequest {
    private String name;
    private String phone;
    private int grade;
    private int classNum;
    private int gender;


    public Student toEntity() {
        return Student.builder()
                .name(name)
                .phone(phone)
                .grade(grade)
                .classNum(classNum)
                .gender(gender)
                .build();
    }
}
