package org.example.educlass.exam.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class StudentTestMarkRequest {
    private Long studentId;
    private Long StudentTestId;
    private List<StudentTestAnswerDto> studentAnswers;
}
