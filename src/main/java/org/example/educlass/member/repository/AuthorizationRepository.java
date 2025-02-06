package org.example.educlass.member.repository;

import org.example.educlass.member.domain.Authorization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorizationRepository extends JpaRepository<Authorization, Long> {
}
