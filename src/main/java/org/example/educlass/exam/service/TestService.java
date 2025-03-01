package org.example.educlass.exam.service;


import lombok.RequiredArgsConstructor;
import org.example.educlass.exam.domain.Test;
import org.example.educlass.exam.dto.TestRequest;
import org.example.educlass.exam.repository.TestRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TestService {

    private final TestRepository testRepository;

    // 테스트 생성
    @Transactional
    public Test createTest(TestRequest testRequest) {
        return testRepository.save(testRequest.toEntity());
    }

    // 개별 테스트 조회
    public Test getTestById(Long id) {

        return testRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Test not found: " + id));
    }

    // 전체 테스트 조회
    public List<Test> findAll() {
        return testRepository.findAll();
    }

    // 개별 테스트 삭제
    public void deleteTestById(Long id) {
        testRepository.deleteById(id);
    }


}
