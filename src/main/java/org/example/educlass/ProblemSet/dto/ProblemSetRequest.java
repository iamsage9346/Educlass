package org.example.educlass.ProblemSet.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProblemSetRequest {

    private Long testId;
    private int chapter;
    private int grade;
    private int problemCount = 10;

    public ProblemSetRequest(Long testId, int chapter, int grade) {
        this.testId = testId;
        this.chapter = chapter;
        this.grade = grade;
    }
}
