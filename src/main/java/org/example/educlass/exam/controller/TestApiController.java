package org.example.educlass.exam.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.educlass.exam.domain.Test;
import org.example.educlass.exam.dto.TestRequest;
import org.example.educlass.exam.dto.TestResponse;
import org.example.educlass.exam.service.TestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Test API", description = "시험 관련 API")
@RestController
@RequiredArgsConstructor
public class TestApiController {

    private final TestService testService;

        @Operation(summary = "시험 생성", description = "시험을 생성합니다.")
        @PostMapping("/api/test")
        public ResponseEntity<TestResponse> createTest(@RequestBody TestRequest testRequest) {
            Test test = testService.createTest(testRequest);

            return ResponseEntity.ok(new TestResponse(test));
        }

        @Operation(summary = "시험 개별 조회", description = "id 별 시험을 조회합니다.")
        @GetMapping("/api/test/{id}")
        public ResponseEntity<TestResponse> getTestById(@PathVariable Long id) {
            Test test = testService.getTestById(id);

        return ResponseEntity.ok()
                .body(new TestResponse(test));
    }

    @Operation(summary = "시험 전체 조회", description = "전체 시험을 조회합니다.")
    @GetMapping("/api/test")
    public ResponseEntity<List<TestResponse>> getAllTests() {
        List<TestResponse> Tests = testService.findAll()
                .stream()
                .map(TestResponse::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok()
                .body(Tests);
    }

    @Operation(summary = "개별 시험 삭제", description = "id 별 문제를 삭제합니다.")
    @DeleteMapping("/api/test/{id}")
    public ResponseEntity<Void> deleteTestById(@PathVariable Long id) {
        testService.deleteTestById(id);

        return ResponseEntity.noContent().build();
    }
}
