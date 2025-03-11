package org.example.educlass.ProblemSet.repository;

import org.example.educlass.ProblemSet.domain.ProblemSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProblemSetRepository extends JpaRepository<ProblemSet, Long> {
    @Query("SELECT ps FROM ProblemSet ps LEFT JOIN FETCH ps.problemSetToProblems psp LEFT JOIN FETCH psp.problem WHERE ps.id = :id")
    Optional<ProblemSet> findByIdWithProblems(@Param("id") Long id);

}
