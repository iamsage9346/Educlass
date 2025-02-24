package org.example.educlass.ProblemSet.repository;

import org.example.educlass.ProblemSet.domain.Problem;
import org.example.educlass.ProblemSet.domain.ProblemType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProblemRepository extends JpaRepository<Problem, Long> {

    List<Problem> findByGradeAndChapter(int grade, int chapter);

    List<Problem> findByGradeAndChapterAndType(int grade, int chapter, ProblemType type);

}
