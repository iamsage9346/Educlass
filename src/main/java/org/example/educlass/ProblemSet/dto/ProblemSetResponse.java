package org.example.educlass.ProblemSet.dto;

import lombok.Getter;
import org.example.educlass.ProblemSet.domain.ProblemSet;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ProblemSetResponse {
    private List<ProblemResponse> problems = new ArrayList<>();

    public ProblemSetResponse(ProblemSet problemSet) {
        problemSet.getProblems().forEach(problem -> this.problems.add(new ProblemResponse(problem)));
    }

}
