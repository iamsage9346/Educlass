package org.example.educlass.exam.service;

import lombok.RequiredArgsConstructor;
import org.example.educlass.exam.domain.Problem;
import org.example.educlass.exam.domain.ProblemSet;
import org.example.educlass.exam.dto.ProblemSetRequest;
import org.example.educlass.exam.dto.ProblemSetResponse;
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

    // 특정 챕터 문제 랜덤 10개 생성
    @Transactional
    public ProblemSetResponse createProblemSet(ProblemSetRequest problemSetRequest) {
        Test test = testRepository.findById(problemSetRequest.getTestId())
                .orElseThrow(() ->
                        new IllegalArgumentException("Test not found: " + problemSetRequest.getTestId()));

        List<Problem> randomProblems = problemRepository.
                findRandomProblemsByChapter(problemSetRequest.getChapterId(), 5);

        ProblemSet problemSet = new ProblemSet();
        problemSet.setTest(test);
        problemSet.setChapter(problemSetRequest.getChapterId());
        problemSet.setProblems(randomProblems);

        ProblemSet savedProblemSet = problemSetRepository.save(problemSet);

        return new ProblemSetResponse(savedProblemSet);
    }

}
