package org.example.educlass.exam.dto;

import lombok.Getter;
import org.example.educlass.exam.domain.StudentLecture;

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

    public StudentLectureResponse(StudentLecture studentLecture) {
        this.studentId = studentLecture.getId();
        this.lectureId = studentLecture.getId();
        this.progress = studentLecture.getProgress();
    }
}
