package org.example.educlass.ProblemSet.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "problem_set_to_problem")
public class ProblemSetToProblem {

    @EmbeddedId
    private ProblemSetToProblemId id;

    @ManyToOne
    @MapsId("problemSetId")
    @JoinColumn(name = "problem_set_id")
    private ProblemSet problemSet;

    @ManyToOne
    @MapsId("problemId")
    @JoinColumn(name = "problem_id")
    private Problem problem;

    public ProblemSetToProblem(ProblemSet problemSet, Problem problem) {
        this.id = new ProblemSetToProblemId(problemSet.getId(), problem.getId());
        this.problemSet = problemSet;
        this.problem = problem;
    }
}
