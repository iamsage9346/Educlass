package org.example.educlass.exam.service;

import lombok.RequiredArgsConstructor;
import org.example.educlass.exam.domain.Problem;
import org.example.educlass.exam.dto.ProblemRequest;
import org.example.educlass.exam.dto.ProblemResponse;
import org.example.educlass.exam.repository.ProblemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public final class ProblemService {

    private final ProblemRepository problemRepository;

    // 문제 생성 메소드
    public ProblemResponse save(ProblemRequest request) {
        Problem saveProblem = problemRepository.save(request.toEntity());
        ProblemResponse problemResponse = new ProblemResponse(saveProblem);

        return problemResponse;
    }

    // 문제 조회 메소드
    public List<Problem> findAll() {
        return problemRepository.findAll();
    }

    // 개별 문제 조회 메소드
    public Problem findById(Long id) {
        return problemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not found: " + id));
    }

    // 문제 수정 메소드
    @Transactional
    public Problem update(Long id, ProblemRequest request) {
        Problem problem = problemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not found: " + id));

        problem.update(request.getContent(), request.getContent(), request.getChapter());

        return problem;
    }

}
