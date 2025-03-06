package org.example.educlass.ProblemSet.service;

import lombok.RequiredArgsConstructor;
import org.example.educlass.ProblemSet.domain.Problem;
import org.example.educlass.ProblemSet.domain.ProblemSetToProblem;
import org.example.educlass.ProblemSet.repository.ProblemRepository;
import org.example.educlass.ProblemSet.repository.ProblemSetRepository;
import org.example.educlass.ProblemSet.repository.ProblemSetToProblemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProblemSetToProblemService {

    private final ProblemSetToProblemRepository problemSetToProblemRepository;
    private final ProblemRepository problemRepository;
    private final ProblemSetRepository problemSetRepository;

    // 불필요한 메소드 일 수 있음
//    @Transactional
//    public ProblemSetToProblem addProblemToProblemSet(Long problemSetId, Long problemId) {
//        ProblemSet problemSet = problemSetRepository.findById(problemSetId)
//                .orElseThrow(() -> new IllegalArgumentException("문제지를 찾을 수 없습니다."));
//        Problem problem = problemRepository.findById(problemId)
//                .orElseThrow(() -> new IllegalArgumentException("문제를 찾을 수 없습니다."));
//
//        ProblemSetToProblem problemSetToProblem = new ProblemSetToProblem();
//        problemSetToProblem.setProblemSet(problemSet);
//        problemSetToProblem.setProblem(problem);
//
//        return problemSetToProblemRepository.save(problemSetToProblem);
//    }

    @Transactional(readOnly = true)
    public List<Problem> getProblemsInProblemSet(Long problemSetId) {
        return problemSetToProblemRepository.findByProblemSetId(problemSetId)
                .stream()
                .map(ProblemSetToProblem::getProblem)
                .collect(Collectors.toList());
    }

    @Transactional
    public void removeProblemFromProblemSet(Long problemSetId, Long problemId) {
        Optional<ProblemSetToProblem> problemSetToProblem = problemSetToProblemRepository
                .findByProblemSetIdAndProblemId(problemSetId, problemId);

        problemSetToProblem.ifPresent(problemSetToProblemRepository::delete);
    }
}
