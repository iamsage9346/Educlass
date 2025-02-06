package org.example.educlass.member.service;

import lombok.RequiredArgsConstructor;
import org.example.educlass.member.domain.Authorization;
import org.example.educlass.member.domain.Certification;
import org.example.educlass.member.domain.User;
import org.example.educlass.member.dto.AddUserRequest;
import org.example.educlass.member.repository.AuthorizationRepository;
import org.example.educlass.member.repository.CertificationRepository;
import org.example.educlass.member.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final AuthorizationRepository authorizationRepository;
    private final CertificationRepository certificationRepository;

    @Transactional
    public Long save(AddUserRequest dto) {
        User user = User.builder()
                .name(dto.getName())
                .phone(dto.getPhone())
                .type(dto.getType())
                .build();
        userRepository.save(user);

        Certification certification = Certification.builder()
                .user(user)
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build();
        certificationRepository.save(certification);

        Authorization authorization = Authorization.builder()
                .user(user)
                .role(dto.getType())
                .build();
        authorizationRepository.save(authorization);

        return user.getId();
    }
}
