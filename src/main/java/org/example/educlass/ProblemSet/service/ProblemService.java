package org.example.educlass.ProblemSet.service;

import lombok.RequiredArgsConstructor;
import org.example.educlass.ProblemSet.domain.Problem;
import org.example.educlass.ProblemSet.dto.ProblemRequest;
import org.example.educlass.ProblemSet.dto.ProblemResponse;
import org.example.educlass.ProblemSet.repository.ProblemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProblemService {

    private final ProblemRepository problemRepository;

    @Transactional
    public ProblemResponse createProblem(ProblemRequest request) {
        Problem problem =  problemRepository.save(request.toEntity());

        return new ProblemResponse(problem);
    }

    public List<ProblemResponse> findAllProblems() {
         List<Problem> problems = problemRepository.findAll();
         return problems
                 .stream()
                 .map(ProblemResponse::new)
                 .collect(Collectors.toList());
    }

    public ProblemResponse findByIdProblem(Long id) {
        Problem problem = problemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not found: " + id));

        return new ProblemResponse(problem);
    }

    @Transactional
    public ProblemResponse updateProblem(Long id, ProblemRequest request) {
        Problem problem = problemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not found: " + id));
        problem.update(request.getContent(), request.getAnswer(), request.getChapter());
        
        return new ProblemResponse(problem);
    }

    @Transactional
    public void deleteProblem(Long id) {
        problemRepository.deleteById(id);
    }

}
