package org.example.educlass.member.dto;

import lombok.Getter;
import org.example.educlass.member.domain.Student;

@Getter
public class StudentListViewResponse {
    private final String name;
    private final String phone;
    private final int grade;
    private final int classNum;
    private final int gender;

    public StudentListViewResponse(Student student) {
        this.name = student.getName();
        this.phone = student.getPhone();
        this.grade = student.getGrade();
        this.classNum = student.getClassNum();
        this.gender = student.getGender();
    }
}