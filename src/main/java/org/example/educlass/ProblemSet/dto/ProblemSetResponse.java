package org.example.educlass.ProblemSet.dto;

import lombok.Getter;
import org.example.educlass.ProblemSet.domain.ProblemSet;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ProblemSetResponse {
    private List<ProblemSet> problemSet;

    public ProblemSetResponse(ProblemSet problemSet) {
        this.problemSet = new ArrayList<>();
        this.problemSet.add(problemSet);
    }
}
