package org.example.educlass.lecture.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.educlass.exam.domain.ProblemSet;
import org.example.educlass.lecture.domain.Lecture;
import org.example.educlass.lecture.domain.Test;

@Getter
@Setter
public class TestRequest {
    private Lecture lecture;
    private ProblemSet problemSet;

    public Test toEntity() {
        return Test.builder()
                .lecture(lecture)
                .problemSet(problemSet)
                .build();
    }
}
