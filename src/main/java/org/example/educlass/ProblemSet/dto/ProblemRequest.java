package org.example.educlass.ProblemSet.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.educlass.ProblemSet.domain.Problem;
import org.example.educlass.ProblemSet.domain.ProblemType;

@Getter
@Setter
public class ProblemRequest {
    private String content;
    private String answer;
    private int chapter;
    private int grade;
    private ProblemType type;

    public Problem toEntity() {
        return Problem.builder()
                .content(content)
                .answer(answer)
                .chapter(chapter)
                .grade(grade)
                .type(type)
                .build();
    }
}
