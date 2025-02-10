package org.example.educlass.lecture.service;


import lombok.RequiredArgsConstructor;
import org.example.educlass.lecture.domain.Test;
import org.example.educlass.lecture.dto.TestRequest;
import org.example.educlass.lecture.dto.TestResponse;
import org.example.educlass.lecture.repository.TestRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TestService {

    private final TestRepository testRepository;

    // 테스트 생성
    @Transactional
    public TestResponse createTest(TestRequest testRequest) {
        Test test = testRepository.save(testRequest.toEntity());

        return new TestResponse(test);
    }

    // 개별 테스트 조회
    public TestResponse getTestById(Long id) {
        Test test = testRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Test not found: " + id));

        return new TestResponse(test);
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
