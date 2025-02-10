package org.example.educlass.lecture.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.educlass.lecture.domain.Test;

@Getter
@NoArgsConstructor
public class TestResponse {
    private Long lectureId;

    public TestResponse(Test test) {
        this.lectureId = test.getLecture().getId();
    }
}