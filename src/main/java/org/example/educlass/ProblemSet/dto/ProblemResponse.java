package org.example.educlass.ProblemSet.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.educlass.ProblemSet.domain.Problem;
import org.example.educlass.ProblemSet.domain.ProblemType;

@Getter
@Setter
public class ProblemResponse {
    private String content;
    private String answer;
    private int chapter;
    private int grade;
    private ProblemType type;

    public ProblemResponse(Problem problem) {
        this.content = problem.getContent();
        this.answer = problem.getAnswer();
        this.chapter = problem.getChapter();
        this.grade = problem.getGrade();
        this.type = problem.getProblemType();
    }
}
