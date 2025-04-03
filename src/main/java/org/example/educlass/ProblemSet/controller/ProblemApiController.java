package org.example.educlass.ProblemSet.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.educlass.ProblemSet.dto.ProblemRequest;
import org.example.educlass.ProblemSet.dto.ProblemResponse;
import org.example.educlass.ProblemSet.service.ProblemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Problem API", description = "문제 관련 API")
@RequiredArgsConstructor
@RestController
public class ProblemApiController {

    private final ProblemService problemService;

    @Operation(summary = "문제 생성", description = "새로운 문제를 생성합니다.")
    @PostMapping("/api/problem")
    public ResponseEntity<ProblemResponse> createProblem(@RequestBody ProblemRequest problemRequest) {
        ProblemResponse problemResponse = problemService.createProblem(problemRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(problemResponse);
    }

    @Operation(summary = "모든 문제 조회", description = "모든 문제를 조회합니다.")
    @GetMapping("/api/problem")
    public ResponseEntity<List<ProblemResponse>> getAllProblems() {
        List<ProblemResponse> problems = problemService.findAllProblems();
        return ResponseEntity.ok()
                .body(problems);
    }

    @Operation(summary = "개별 문제 조회", description = "id 별 문제를 조회합니다.")
    @GetMapping("/api/problem/{id}")
    public ResponseEntity<ProblemResponse> getProblemById(@PathVariable Long id) {
        ProblemResponse problemResponse = problemService.findByIdProblem(id);

        return ResponseEntity.ok()
                .body(problemResponse);
    }

    @Operation(summary = "개별 문제 수정", description = "id 별 문제를 수정합니다.")
    @PutMapping("/api/problem/{id}")
    public ResponseEntity<ProblemResponse> updateProblem(@PathVariable Long id, @RequestBody ProblemRequest problemRequest) {
        ProblemResponse problemResponse = problemService.updateProblem(id, problemRequest);
        return ResponseEntity.ok(problemResponse);
    }

    @Operation(summary = "개별 문제 삭제", description = "id 별 문제를 삭제합니다.")
    @DeleteMapping("/api/problem/{id}")
    public ResponseEntity<Void> deleteProblem(@PathVariable Long id) {
        problemService.deleteProblem(id);

        return ResponseEntity.noContent().build();
    }

}
