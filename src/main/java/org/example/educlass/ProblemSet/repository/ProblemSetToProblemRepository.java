package org.example.educlass.ProblemSet.repository;

import org.example.educlass.ProblemSet.domain.ProblemSetToProblem;
import org.example.educlass.ProblemSet.domain.ProblemSetToProblemId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProblemSetToProblemRepository extends JpaRepository<ProblemSetToProblem, ProblemSetToProblemId> {

    // 특정 문제지에 포함된 문제들 조회
    List<ProblemSetToProblem> findByProblemSetId(Long problemSetId);

    // 특정 문제지에 포함된
    void deleteByProblemSet_Id(Long problemSetId);

    // 특정 문제지에서 특정 문제만 조회
    Optional<ProblemSetToProblem> findByProblemSetIdAndProblemId(Long problemSetId, Long problemId);
}
