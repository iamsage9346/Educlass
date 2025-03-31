package org.example.educlass.ProblemSet.service;

import lombok.RequiredArgsConstructor;
import org.example.educlass.ProblemSet.domain.ProblemSetToProblem;
import org.example.educlass.ProblemSet.dto.ProblemResponse;
import org.example.educlass.ProblemSet.repository.ProblemSetToProblemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProblemSetToProblemService {

    private final ProblemSetToProblemRepository problemSetToProblemRepository;

    @Transactional(readOnly = true)
    public List<ProblemResponse> getProblemsInProblemSet(Long problemSetId) {

        return problemSetToProblemRepository.findByProblemSetId(problemSetId)
                .stream()
                .map(problem -> new ProblemResponse(
                        problem.getProblem()
                )).toList();
    }

    @Transactional
    public void removeProblemFromProblemSet(Long problemSetId, Long problemId) {
        Optional<ProblemSetToProblem> problemSetToProblem = problemSetToProblemRepository
                .findByProblemSetIdAndProblemId(problemSetId, problemId);

        problemSetToProblem.ifPresent(problemSetToProblemRepository::delete);
    }
}
