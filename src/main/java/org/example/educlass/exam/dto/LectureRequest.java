package org.example.educlass.exam.dto;

import lombok.Getter;
import org.example.educlass.exam.domain.Lecture;


@Getter
public class LectureRequest {
    private String name;
    private String link;
    private int chapter;
    private int grade;

    public Lecture toEntity() {
        return Lecture.builder()
                .name(name)
                .link(link)
                .chapter(chapter)
                .grade(grade)
                .build();
    }
}
