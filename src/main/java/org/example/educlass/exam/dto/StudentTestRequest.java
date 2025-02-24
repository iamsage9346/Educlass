package org.example.educlass.exam.dto;

import lombok.Getter;

@Getter
public class StudentTestRequest {
    private Long studentId;
    private Long testId;
    private int grade;
    private int chapter;

}