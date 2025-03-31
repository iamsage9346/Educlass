package org.example.educlass.exam.repository;

import org.example.educlass.exam.domain.StudentExam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentExamRepository extends JpaRepository<StudentExam, Long> {

    public Optional<StudentExam> findByStudentIdAndStudentLectureId(Long studentId, Long lectureId);
}
