package org.example.educlass.exam.service;

import lombok.RequiredArgsConstructor;
import org.example.educlass.exam.domain.Problem;
import org.example.educlass.exam.domain.ProblemSet;
import org.example.educlass.exam.dto.ProblemSetRequest;
import org.example.educlass.exam.repository.ProblemRepository;
import org.example.educlass.exam.repository.ProblemSetRepository;
import org.example.educlass.lecture.domain.Test;
import org.example.educlass.lecture.repository.TestRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProblemSetService {

    private final ProblemSetRepository problemSetRepository;
    private final ProblemRepository problemRepository;
    private final TestRepository testRepository;

    // 특정 챕터 문제 랜덤 5개 생성
    @Transactional
    public ProblemSet createProblemSet(ProblemSetRequest problemSetRequest) {
        Test test = testRepository.findById(problemSetRequest.getTestId())
                .orElseThrow(() ->
                        new IllegalArgumentException("Test not found: " + problemSetRequest.getTestId()));

        int problemCount = 5;

        List<Problem> randomProblems = problemRepository.
                findRandomProblemsByChapter(problemSetRequest.getChapterId(), problemCount);

        ProblemSet problemSet = new ProblemSet();
        problemSet.addProblemSet(test, problemSetRequest.getChapterId(), randomProblems);

        return problemSetRepository.save(problemSet);
    }

    // 문제지 조회
    public ProblemSet findProblemSetById(Long id) {
        return problemSetRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("ProblemSet not found: " + id));
    }

    // 문제지 삭제
    @Transactional
    public void deleteProblemSet(Long problemSetId) {
        if (!problemSetRepository.existsById(problemSetId)) {
            throw new IllegalArgumentException("Problem set not found: " + problemSetId);
        }
        problemSetRepository.deleteById(problemSetId);
    }


}
