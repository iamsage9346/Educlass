package org.example.educlass.exam.dto;

import lombok.Getter;
import org.example.educlass.ProblemSet.domain.ProblemSet;
import org.example.educlass.exam.domain.StudentLecture;
import org.example.educlass.exam.domain.StudentTest;
import org.example.educlass.member.domain.Student;

@Getter
public class StudentTestRequest {
    private Student student;
    private StudentLecture studentLecture;
    private ProblemSet problemSet;

    public StudentTest toEntity() {
        return StudentTest.builder()
                .student(student)
                .studentLecture(studentLecture)
                .problemSet(problemSet)
                .build();
    }

}