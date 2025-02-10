package org.example.educlass.exam.service;

import lombok.RequiredArgsConstructor;
import org.example.educlass.exam.dto.ProblemRequest;
import org.example.educlass.exam.repository.ProblemRepository;
import org.example.educlass.exam.domain.Problem;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProblemService {

    private final ProblemRepository problemRepository;

    @Transactional
    public Problem save(ProblemRequest request) {
        return problemRepository.save(request.toEntity());
    }

    public List<Problem> findAll() {
        return problemRepository.findAll();
    }

    public Problem findById(Long id) {
        return problemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not found: " + id));
    }

    @Transactional
    public Problem update(Long id, ProblemRequest request) {
        Problem problem = problemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not found: " + id));

        problem.update(request.getContent(), request.getAnswer(), request.getChapter());

        return problem;
    }

    @Transactional
    public void delete(Long id) {
        problemRepository.deleteById(id);
    }
}
