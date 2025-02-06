package org.example.educlass.member.repository;

import org.example.educlass.member.domain.Certification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CertificationRepository extends JpaRepository<Certification, Long> {
    Optional<Certification> findByEmail(String email);
}
