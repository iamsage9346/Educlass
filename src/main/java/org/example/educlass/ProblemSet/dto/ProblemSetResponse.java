package org.example.educlass.ProblemSet.dto;

import lombok.Getter;
import org.example.educlass.ProblemSet.domain.ProblemSet;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ProblemSetResponse {
    private Long testId;
    private List<ProblemSet> problemSets;
    private int chapter;

    public ProblemSetResponse(ProblemSet problemSet) {
        this.testId = problemSet.getTest().getId();
        this.problemSets = new ArrayList<>();
        this.problemSets.add(problemSet);
        this.chapter = getChapter();
    }
}
