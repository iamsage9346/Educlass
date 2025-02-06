package org.example.educlass.exam.dto;

import lombok.Getter;
import org.example.educlass.exam.domain.ProblemSet;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ProblemSetResponse {
    private Long testId;
    private List<ProblemSet> problemSets;
    private Long chapter;

    public ProblemSetResponse(ProblemSet problemSet) {
        this.testId = problemSet.getTest().getId();
        this.problemSets = new ArrayList<>();
        this.problemSets.add(problemSet);
        this.chapter = getChapter();
    }
}
