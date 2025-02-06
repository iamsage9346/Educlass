package org.example.educlass.exam.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.educlass.exam.domain.Problem;

@Getter
@Setter
public class ProblemResponse {
    private String content;
    private String answer;
    private int chapter;

    public ProblemResponse(Problem problem) {
        this.content = problem.getContent();
        this.answer = problem.getAnswer();
        this.chapter = problem.getChapter();
    }
}
