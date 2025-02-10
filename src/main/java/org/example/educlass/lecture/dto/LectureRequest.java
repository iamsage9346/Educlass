package org.example.educlass.lecture.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.educlass.lecture.domain.Lecture;


@Getter
@Setter
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
