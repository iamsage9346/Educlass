package org.example.educlass.exam.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StudentTestSubmissionDto {
    private Long studentTestId;
    private List<StudentTestAnswerDto> studentAnswers;
}
