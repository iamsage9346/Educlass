package org.example.educlass.exam.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.educlass.exam.domain.StudentTest;
import org.example.educlass.exam.dto.StudentTestMarkRequest;
import org.example.educlass.exam.dto.StudentTestRequest;
import org.example.educlass.exam.dto.StudentTestResponse;
import org.example.educlass.exam.dto.StudentTestSubmissionDto;
import org.example.educlass.exam.service.StudentTestService;
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
import java.util.stream.Collectors;

@Tag(name = "StudentTest API", description = "학생당 시험 관련 API")
@RestController
@RequiredArgsConstructor
public class StudentTestApiController {

    private final StudentTestService studentTestService;

    @Operation(summary = "학생시험 생성", description = "학생이 시험을 응시할 때, 시험을 생성합니다.")
    @PostMapping("/api/student-test")
    public ResponseEntity<StudentTest> createStudentTest(@RequestBody StudentTestRequest studentTestRequest) {
        StudentTest studentTest = studentTestService.createStudentTest(studentTestRequest);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(studentTest);
    }

    @Operation(summary = "학생시험 전체 조회", description = "학생들이 본 전체 시험 리스트를 조회합니다.")
    @GetMapping("/api/student-tests")
    public ResponseEntity<List<StudentTestResponse>> getAllStudentTests() {
        List<StudentTestResponse> studentTests = studentTestService.getAllStudentTests()
                .stream()
                .map(StudentTestResponse::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(studentTests);
    }

    @Operation(summary = "학생시험 개별 조회", description = "id 별 학생시험을 조회합니다.")
    @GetMapping("/api/student-test/{id}")
    public ResponseEntity<StudentTestResponse> getStudentTest(@PathVariable Long id) {
        StudentTest studentTest = studentTestService.getStudentTestById(id);
        StudentTestResponse studentTestResponse = new StudentTestResponse(studentTest);

        return ResponseEntity.ok(studentTestResponse);
    }

    @PostMapping("/api/student-test/{id}/submit")
    public ResponseEntity<String> processStudentTestSubmission(@PathVariable Long id, @RequestBody StudentTestSubmissionDto dto) {
        studentTestService.processStudentTestSubmission(id, dto);
        return ResponseEntity.ok("시험이 성공적으로 제출되었습니다.");
    }

    @Operation(summary = "학생시험 채점", description = "id 별 학생시험을 채점합니다.")
    @PutMapping("/api/student-test/{id}/mark")
    public ResponseEntity<Void> markStudentTest(@PathVariable Long id, @RequestBody StudentTestMarkRequest studentTestMarkRequest) {
        studentTestService.markStudentTest(id, studentTestMarkRequest);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/api/student-test/{id}")
    public ResponseEntity<Void> deleteStudentTest(@PathVariable Long id) {
        studentTestService.deleteStudentTest(id);
        return ResponseEntity.noContent().build();
    }
}
