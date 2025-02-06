package org.example.educlass.member.repository;

import org.example.educlass.member.domain.StudentParent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentParentRepository extends JpaRepository<StudentParent, Long> {
}
