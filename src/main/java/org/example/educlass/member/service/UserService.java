package org.example.educlass.member.service;

import lombok.RequiredArgsConstructor;
import org.example.educlass.member.domain.User;
import org.example.educlass.member.dto.AddUserRequest;
import org.example.educlass.member.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User createUser(AddUserRequest addUserRequest) {
        // 중복 체크
        if(userRepository.findByPhone(addUserRequest.getPhone()).isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 연락처로 가입되었습니다.");
        }

        return addUserRequest.toEntity();

    }

    public User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Not found: " + id));
    }

    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public User updateUser(Long id, AddUserRequest addUserRequest) {

        User user = findUserById(id);
        user.updateUser(addUserRequest.getEmail(), addUserRequest.getPassword());

        return user;
    }

}
