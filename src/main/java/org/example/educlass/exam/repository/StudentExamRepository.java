package org.example.educlass.exam.repository;

import org.example.educlass.exam.domain.StudentExam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentExamRepository extends JpaRepository<StudentExam, Long> {
}
