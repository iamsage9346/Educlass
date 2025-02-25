package org.example.educlass.member.dto;

import org.example.educlass.member.domain.Student;
import org.example.educlass.member.domain.User;

public class StudentResponse {

    private User user;
    private int grade;
    private int classNum;
    private int gender;

    public StudentResponse(Student student) {
        this.user = student.getUser();
        this.grade = student.getGrade();
        this.classNum = student.getClassNum();
        this.gender = student.getGender();
    }
}
