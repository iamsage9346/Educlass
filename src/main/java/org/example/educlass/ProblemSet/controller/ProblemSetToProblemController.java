package org.example.educlass.ProblemSet.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.educlass.ProblemSet.dto.ProblemResponse;
import org.example.educlass.ProblemSet.service.ProblemSetToProblemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "ProblemSetToProblem API", description = "문제지-문제 관련 API")
@RestController
@RequiredArgsConstructor
public class ProblemSetToProblemController {

    private final ProblemSetToProblemService problemSetToProblemService;

    @Operation(summary = "문제지 내 문제 조회", description = "문제지 내 모든 문제를 조회합니다.")
    @GetMapping("/{problemSetId}/problems")
    public ResponseEntity<List<ProblemResponse>> getProblemsInProblemSet(@PathVariable Long problemSetId) {
        List<ProblemResponse> problems = problemSetToProblemService.getProblemsInProblemSet(problemSetId);
        return ResponseEntity.ok(problems);
    }

    @Operation(summary = "문제지 문제 분리", description = "문제지 안에 있는 문제를 삭제합니다.")
    @DeleteMapping("/problem-set/{problemSetId}/problem/{problemId}")
    public ResponseEntity<Void> removeProblemFromProblemSet(
            @PathVariable Long problemSetId,
            @PathVariable Long problemId) {
        problemSetToProblemService.removeProblemFromProblemSet(problemSetId, problemId);
        return ResponseEntity.noContent().build();
    }
}
