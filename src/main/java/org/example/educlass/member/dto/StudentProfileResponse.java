package org.example.educlass.member.dto;

import lombok.Getter;

@Getter
public class StudentProfileResponse {
    private Long studentId;
    private String name;
    private int grade;
    private int classNum;
    private String email;

    public StudentProfileResponse(Long studentId, String name, int grade, int classNum, String email) {
        this.studentId = studentId;
        this.name = name;
        this.grade = grade;
        this.classNum = classNum;
        this.email = email;
    }
}
