package org.example.educlass.exam.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.educlass.ProblemSet.domain.ProblemType;

@Getter
@Setter
@NoArgsConstructor
public class StudentTestAnswerDto {
    private Long problemId;
    private String answer;
    private ProblemType problemType;
}
