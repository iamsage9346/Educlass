package org.example.educlass.exam.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.educlass.exam.domain.Lecture;
import org.example.educlass.exam.domain.Test;

@Getter
@Setter
public class TestRequest {
    private Lecture lecture;

    @Builder
    public Test toEntity() {
        return Test.builder()
                .lecture(lecture)
                .build();
    }
}
