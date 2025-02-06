package org.example.educlass.exam.repository;

import org.example.educlass.exam.domain.Problem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


@Repository
public interface ProblemRepository extends JpaRepository<Problem, Long> {
    @Query(value = "SELECT p FROM Problem p WHERE p.chapter = :chapterId ORDER BY FUNCTION('RAND') LIMIT :limit")
    List<Problem> findRandomProblemsByChapter(@Param("chapterId") Long chapterId, @Param("limit") int limit);
}
