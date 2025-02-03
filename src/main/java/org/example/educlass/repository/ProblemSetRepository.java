package org.example.educlass.repository;

import org.example.educlass.domain.ProblemSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProblemSetRepository extends JpaRepository<ProblemSet, Long> {
}
