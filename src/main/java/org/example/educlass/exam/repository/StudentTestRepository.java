package org.example.educlass.exam.repository;

import org.example.educlass.exam.domain.StudentTest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentTestRepository extends JpaRepository<StudentTest, Long> {
}
