package org.example.educlass.ProblemSet.dto;

import lombok.Getter;
import org.example.educlass.ProblemSet.domain.Problem;
import org.example.educlass.ProblemSet.domain.ProblemSet;
import org.example.educlass.ProblemSet.domain.ProblemType;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ProblemSetResponse {

    private final Long problemSetId;
    private final List<ProblemDto> problems;

    public ProblemSetResponse(ProblemSet problemSet) {
        this.problemSetId = problemSet.getId();
        this.problems = problemSet.getProblemSetToProblems().stream()
                .map(mapping -> new ProblemDto(mapping.getProblem()))
                .collect(Collectors.toList());
    }

    @Getter
    public static class ProblemDto {
        private final Long id;
        private final ProblemType type;
        private final String content;

        public ProblemDto(Problem problem) {
            this.id = problem.getId();
            this.type = problem.getProblemType();
            this.content = problem.getContent();
        }
    }
}
