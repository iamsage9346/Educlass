package org.example.educlass.exam.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.educlass.exam.domain.Lecture;

@Getter
@Setter
public class LectureResponse {
    private String name;
    private String link;
    private int chapter;
    private int grade;

    public LectureResponse(Lecture lecture) {
        this.name = lecture.getName();
        this.link = lecture.getLink();
        this.chapter = lecture.getChapter();
        this.grade = lecture.getGrade();
    }
}
