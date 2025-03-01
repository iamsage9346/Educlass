package org.example.educlass.member.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.educlass.member.domain.Student;

@Getter
@Setter
public class StudentViewResponse {

    private Long id;
    private String name;
    private String phone;
    private int grade;
    private int classNum;
    private int gender;

    public StudentViewResponse(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.phone = student.getPhone();
        this.grade = student.getGrade();
        this.classNum = student.getClassNum();
        this.gender = student.getGender();
    }
}
