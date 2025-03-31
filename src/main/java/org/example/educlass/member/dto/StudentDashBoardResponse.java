package org.example.educlass.member.dto;

import lombok.Getter;

@Getter
public class StudentDashBoardResponse {
    private Long studentId;
    private String studentName;

    public StudentDashBoardResponse(Long studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }
}
