package org.example.educlass.member.dto;

import org.example.educlass.member.domain.Student;

public class StudentResponse {

    private String name;
    private String phone;
    private int grade;
    private int classNum;
    private int gender;

    public StudentResponse(Student student) {
        this.name = student.getName();
        this.phone = student.getPhone();
        this.grade = student.getGrade();
        this.classNum = student.getClassNum();
        this.gender = student.getGender();
    }
}
