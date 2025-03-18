package org.example.educlass.exam.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class StudentExamMarkRequest {
    private Long studentId;
    private Long StudentExamId;
    private List<StudentExamAnswerDto> studentAnswers;
}
