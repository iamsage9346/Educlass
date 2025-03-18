package org.example.educlass.exam.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StudentExamSubmissionDto {
    private Long studentExamId;
    private List<StudentExamAnswerDto> studentAnswers;
}
