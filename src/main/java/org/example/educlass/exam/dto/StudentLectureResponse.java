package org.example.educlass.exam.dto;

import lombok.Getter;

@Getter
public class StudentLectureResponse {
    private Long studentId;
    private Long lectureId;
    private int progress;

    public StudentLectureResponse(Long id, Long lectureId, int progress) {
        this.studentId = id;
        this.lectureId = lectureId;
        this.progress = progress;
    }
}
