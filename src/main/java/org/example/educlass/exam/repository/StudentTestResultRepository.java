package org.example.educlass.exam.repository;

import org.example.educlass.exam.domain.StudentTestResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentTestResultRepository extends JpaRepository<StudentTestResult, Long> {
}
