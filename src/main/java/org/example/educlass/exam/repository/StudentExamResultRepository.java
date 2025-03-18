package org.example.educlass.exam.repository;

import org.example.educlass.exam.domain.StudentExamResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentExamResultRepository extends JpaRepository<StudentExamResult, Long> {
}
