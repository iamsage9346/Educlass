package org.example.educlass.lecture.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.educlass.lecture.domain.Lecture;

@Getter
@Setter
public class LectureResponse {
    private String name;
    private int chapter;
    private String link;
    private int grade;

    public LectureResponse(Lecture lecture) {
        this.name = lecture.getName();
        this.chapter = lecture.getChapter();
        this.link = lecture.getLink();
        this.grade = lecture.getGrade();
    }
}
