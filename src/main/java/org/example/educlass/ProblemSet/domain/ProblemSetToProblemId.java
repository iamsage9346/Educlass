package org.example.educlass.ProblemSet.domain;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
public class ProblemSetToProblemId implements Serializable {
    private Long problemSetId;
    private Long problemId;

    public ProblemSetToProblemId() {}

    public ProblemSetToProblemId(Long problemSetId, Long problemId) {
        this.problemSetId = problemSetId;
        this.problemId = problemId;
    }
}
