package org.example.educlass.exam.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.educlass.ProblemSet.domain.ProblemSet;
import org.example.educlass.exam.domain.StudentExam;
import org.example.educlass.exam.domain.StudentLecture;
import org.example.educlass.member.domain.Student;

@Getter
@Setter
public class StudentExamRequest {
    private Long studentId;
    private Long studentLectureId;
    private Long problemSetId;

    public StudentExam toEntity(Student student, StudentLecture studentLecture, ProblemSet problemSet) {
        return StudentExam.builder()
                .student(student)
                .studentLecture(studentLecture)
                .problemSet(problemSet)
                .build();
    }
}
