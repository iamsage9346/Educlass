package org.example.educlass.ProblemSet.repository;

import org.example.educlass.ProblemSet.domain.Problem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProblemRepository extends JpaRepository<Problem, Long> {
    @Query(value = "SELECT * FROM problem p WHERE p.grade = :grade AND p.chapter = :chapter AND p.problemtype = :type ORDER BY RAND() LIMIT :count", nativeQuery = true)
    List<Problem> findRandomProblems(@Param("grade") int grade, @Param("chapter") int chapter, @Param("type") String type, @Param("count") int count);

}
