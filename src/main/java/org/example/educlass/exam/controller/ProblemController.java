package org.example.educlass.exam.controller;

import lombok.RequiredArgsConstructor;
import org.example.educlass.exam.domain.Problem;
import org.example.educlass.exam.dto.ProblemResponse;
import org.example.educlass.exam.dto.ProblemRequest;
import org.example.educlass.exam.service.ProblemService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProblemController {

    private final ProblemService problemService;

    @PostMapping("/api/problem")
    public ProblemResponse createProblem (@RequestBody ProblemRequest problemRequest) {
        return problemService.save(problemRequest);
    }

    @GetMapping("/api/problem")
    public ResponseEntity<List<ProblemResponse>> getAllProblems() {
        List<ProblemResponse> problems = problemService.findAll()
                .stream()
                .map(ProblemResponse::new)
                .toList();
        return ResponseEntity.ok()
                .body(problems);
    }

    @GetMapping("/api/problem/{id}")
    public ResponseEntity<ProblemResponse> getProblemById(@PathVariable Long id) {
        Problem problem = problemService.findById(id);

        return ResponseEntity.ok()
                .body(new ProblemResponse(problem));
    }

    @PutMapping("/api/problem/{id}")
    public ResponseEntity<Problem> updateProblem(@PathVariable Long id, @RequestBody ProblemRequest problemRequest) {
        Problem problem = problemService.update(id, problemRequest);

        return ResponseEntity.ok()
                .body(problem);

    }
}
