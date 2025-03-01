package org.example.educlass.ProblemSet.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.educlass.ProblemSet.domain.Problem;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Problem API", description = "문제 관련 API")
@RequiredArgsConstructor
@RestController
public class ProblemApiController {

    // 컨트롤러에서 하지말아야 할 것 : 비즈니스 로직이 들어가는것을 권장하지 않는다.
    // EndPoint - API를 호출하는 시점
    // get요청을 가장 많이 만든다.

    private final ProblemService problemService;

    @Operation(summary = "문제 생성", description = "새로운 문제를 생성합니다.")
    @PostMapping("/api/problem")
    public ResponseEntity<ProblemResponse> createProblem(@RequestBody ProblemRequest problemRequest) {
        Problem problem = problemService.createProblem(problemRequest);
        ProblemResponse response = new ProblemResponse(problem);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "모든 문제 조회", description = "모든 문제를 조회합니다.")
    @GetMapping("/api/problem")
    public ResponseEntity<List<ProblemResponse>> getAllProblems() {
        List<ProblemResponse> problems = problemService.findAllProblems()
                .stream()
                .map(ProblemResponse::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok()
                .body(problems);
    }

    @Operation(summary = "개별 문제 조회", description = "id 별 문제를 조회합니다.")
    @GetMapping("/api/problem/{id}")
    public ResponseEntity<ProblemResponse> getProblemById(@PathVariable Long id) {
        Problem problem = problemService.findByIdProblem(id);

        return ResponseEntity.ok()
                .body(new ProblemResponse(problem));
    }

    @Operation(summary = "개별 문제 수정", description = "id 별 문제를 수정합니다.")
    @PutMapping("/api/problem/{id}")
    public ResponseEntity<ProblemResponse> updateProblem(@PathVariable Long id, @RequestBody ProblemRequest problemRequest) {
        Problem updatedProblem = problemService.updateProblem(id, problemRequest);
        return ResponseEntity.ok(new ProblemResponse(updatedProblem));
    }

    @Operation(summary = "개별 문제 삭제", description = "id 별 문제를 삭제합니다.")
    @DeleteMapping("/api/problem/{id}")
    public ResponseEntity<Void> deleteProblem(@PathVariable Long id) {
        problemService.deleteProblem(id);

        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "챕터 별 문제 필터", description = "학년과 챕터 별 문제를 조회합니다.")
    @GetMapping("/api/problems")
    public ResponseEntity<List<ProblemResponse>> filterProblems(@RequestParam int grade, @RequestParam int chapter) {
        List<ProblemResponse> problems = problemService.filterProblems(grade, chapter)
                .stream()
                .map(ProblemResponse::new)
                .toList();
        return ResponseEntity.ok()
                .body(problems);
    }
}
