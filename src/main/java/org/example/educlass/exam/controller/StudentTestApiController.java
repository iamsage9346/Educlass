package org.example.educlass.exam.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.educlass.exam.domain.StudentTest;
import org.example.educlass.exam.dto.StudentTestMarkRequest;
import org.example.educlass.exam.dto.StudentTestRequest;
import org.example.educlass.exam.dto.StudentTestResponse;
import org.example.educlass.exam.service.StudentTestService;
import org.springframework.http.ResponseEntity;
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
    @PostMapping("/api/studentTest")
    public ResponseEntity<StudentTestResponse> createStudentTest(StudentTestRequest studentTestRequest) {
        StudentTest studentTest = studentTestService.createStudentTest(studentTestRequest);
        StudentTestResponse studentTestResponse = new StudentTestResponse(studentTest);

        return ResponseEntity.ok(studentTestResponse);
    }

    @Operation(summary = "학생시험 전체 조회", description = "학생들이 본 전체 시험 리스트를 조회합니다.")
    @GetMapping("/api/studentTests")
    public ResponseEntity<List<StudentTestResponse>> getAllStudentTests() {
        List<StudentTestResponse> studentTests = studentTestService.getAllStudentTests()
                .stream()
                .map(StudentTestResponse::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(studentTests);
    }

    @Operation(summary = "학생시험 개별 조회", description = "id 별 학생시험을 조회합니다.")
    @GetMapping("/api/studentTest/{id}")
    public ResponseEntity<StudentTestResponse> getStudentTest(@PathVariable Long id) {
        StudentTest studentTest = studentTestService.getStudentTestById(id);
        StudentTestResponse studentTestResponse = new StudentTestResponse(studentTest);

        return ResponseEntity.ok(studentTestResponse);
    }

    @Operation(summary = "학생시험 채점", description = "id 별 학생시험을 채점합니다.")
    @PutMapping("/api/studentTest/{id}/mark")
    public ResponseEntity<Void> markStudentTest(@PathVariable Long id, @RequestBody StudentTestMarkRequest studentTestMarkRequest) {
        studentTestService.markStudentTest(id, studentTestMarkRequest);

        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "학생시험 응시", description = "학생 시험 응시 시작 후 시험시간이 시작됩니다.")
    @PutMapping("/api/studentTest/{id}/take")
    public ResponseEntity<Void> takeStudentTest(@PathVariable Long id) {
        studentTestService.takeStudentTest(id);
        return ResponseEntity.noContent().build();
    }
}
