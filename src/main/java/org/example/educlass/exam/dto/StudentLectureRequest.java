package org.example.educlass.exam.dto;

import lombok.Getter;

@Getter
public class StudentLectureRequest {
    private Long lectureId;
    private Long studentId;
    private int progress;
}
