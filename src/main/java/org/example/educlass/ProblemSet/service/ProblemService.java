package org.example.educlass.ProblemSet.service;

import lombok.RequiredArgsConstructor;
import org.example.educlass.ProblemSet.dto.ProblemRequest;
import org.example.educlass.ProblemSet.repository.ProblemRepository;
import org.example.educlass.ProblemSet.domain.Problem;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProblemService {

    private final ProblemRepository problemRepository;

    @Transactional
    public Problem createProblem(ProblemRequest request) {
        return problemRepository.save(request.toEntity());
    }

    public List<Problem> findAllProblems() {
        return problemRepository.findAll();
    }

    public Problem findByIdProblem(Long id) {
        return problemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not found: " + id));
    }

    @Transactional
    public Problem updateProblem(Long id, ProblemRequest request) {
        Problem problem = findByIdProblem(id);

        problem.update(request.getContent(), request.getAnswer(), request.getChapter());

        return problem;
    }

    @Transactional
    public void deleteProblem(Long id) {
        problemRepository.deleteById(id);
    }

}
