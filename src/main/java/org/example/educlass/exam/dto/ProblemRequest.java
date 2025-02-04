package org.example.educlass.exam.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.educlass.exam.domain.Problem;

@Getter
@Setter
public class ProblemRequest {
    private String content;
    private String answer;
    private int chapter;

    public Problem toEntity() {
        return Problem.builder()
                .content(content)
                .answer(answer)
                .chapter(chapter)
                .build();
    }
}
