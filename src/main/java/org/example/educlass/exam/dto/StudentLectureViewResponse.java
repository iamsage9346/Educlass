package org.example.educlass.exam.dto;

import lombok.Getter;

@Getter
public class StudentLectureViewResponse {
    private Long studentId;
    private Long lectureId;
    private int progress;
    private String lectureName;

    public StudentLectureViewResponse(Long studentId, Long lectureId, int progress, String lectureName) {
        this.studentId = studentId;
        this.lectureId = lectureId;
        this.progress = progress;
        this.lectureName = lectureName;
    }
}


