package org.example.educlass.exam.repository;

import org.example.educlass.exam.domain.ProblemSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProblemSetRepository extends JpaRepository<ProblemSet, Long> {
}
