package org.example.educlass.ProblemSet.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.educlass.ProblemSet.dto.ProblemSetResponse;
import org.example.educlass.ProblemSet.service.ProblemSetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "ProblemSet API", description = "문제지 관련 API")
@RequiredArgsConstructor
@RestController
public class ProblemSetApiController {

    private final ProblemSetService problemSetService;

    @Operation(summary = "문제지 생성", description = "랜덤으로 n개의 문제를 골라 문제지를 생성합니다.")
    @PostMapping("/api/problem-set")
    public ResponseEntity<ProblemSetResponse> createProblemSet(@PathVariable Long id) {
        ProblemSetResponse problemSet = problemSetService.createProblemSet(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(problemSet);
    }

    @Operation(summary = "개별 문제지 조회", description = "id 별 문제지를 조회합니다.")
    @GetMapping("/api/problem-set/{id}")
    public ResponseEntity<ProblemSetResponse> getProblemSet(@PathVariable Long id) {
        ProblemSetResponse problemSet = problemSetService.findProblemSetById(id);

        return ResponseEntity.status(HttpStatus.OK).body(problemSet);
    }

    @Operation(summary = "개별 문제지 삭제", description = "id 별 문제지를 삭제합니다.")
    @DeleteMapping("/api/problem-set/{id}")
    public ResponseEntity<Void> deleteProblemSet(@PathVariable Long id) {
        problemSetService.deleteProblemSet(id);

        return ResponseEntity.noContent().build();
    }
}
