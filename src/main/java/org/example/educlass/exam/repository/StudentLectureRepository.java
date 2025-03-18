package org.example.educlass.exam.repository;

import org.example.educlass.exam.domain.StudentLecture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentLectureRepository extends JpaRepository<StudentLecture, Long> {

    List<StudentLecture> findByStudentId(Long studentId);
    Optional<StudentLecture> findByStudentIdAndLectureId(Long studentId, Long lectureId);

}
