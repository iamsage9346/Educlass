package org.example.educlass.exam.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.educlass.exam.dto.StudentExamMarkRequest;
import org.example.educlass.exam.dto.StudentExamRequest;
import org.example.educlass.exam.dto.StudentExamResponse;
import org.example.educlass.exam.dto.StudentExamSubmissionDto;
import org.example.educlass.exam.service.StudentExamService;
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

@Tag(name = "StudentExam API", description = "학생당 시험 관련 API")
@RestController
@RequiredArgsConstructor
public class StudentExamApiController {

    private final StudentExamService studentExamService;

    @Operation(summary = "학생시험 생성", description = "학생이 시험을 응시할 때, 시험을 생성합니다.")
    @PostMapping("/api/student-exam")
    public ResponseEntity<StudentExamResponse> createStudentExam(@RequestBody StudentExamRequest studentExamRequest) {
        StudentExamResponse studentExam = studentExamService.createStudentExam(studentExamRequest);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(studentExam);
    }

    // TODO (페이지네이션을 안했을 때, 실행 시간 측정)
    @Operation(summary = "학생시험 전체 조회", description = "학생들이 본 전체 시험 리스트를 조회합니다.")
    @GetMapping("/api/student-exams")
    public ResponseEntity<List<StudentExamResponse>> getAllStudentExams() {
        List<StudentExamResponse> studentExams = studentExamService.getAllStudentExams();

        return ResponseEntity.ok(studentExams);
    }

    @Operation(summary = "학생시험 개별 조회", description = "id 별 학생시험을 조회합니다.")
    @GetMapping("/api/student-exam/{id}")
    public ResponseEntity<StudentExamResponse> getStudentExam(@PathVariable Long id) {
        StudentExamResponse studentExam = studentExamService.getStudentExamById(id);

        return ResponseEntity.ok(studentExam);
    }

    @Operation(summary = "학생시험 제출", description = "학생이 시험에 답안을 제출합니다.")
    @PostMapping("/api/student-exam/{id}/submit")
    public ResponseEntity<String> processStudentExamSubmission(@PathVariable Long id, @RequestBody StudentExamSubmissionDto dto) {
        studentExamService.processStudentExamSubmission(id, dto);
        return ResponseEntity.ok("submit success!"); // 메시지도 영어로 쓰는게 좋다.
    }

    @Operation(summary = "학생시험 채점", description = "id 별 학생시험을 채점합니다.")
    @PutMapping("/api/student-exam/{id}/mark")
    public ResponseEntity<Void> markStudentExam(@PathVariable Long id, @RequestBody StudentExamMarkRequest studentExamMarkRequest) {
        studentExamService.markStudentExam(id, studentExamMarkRequest);

        return ResponseEntity.noContent().build();
    }

    @Operation
    @DeleteMapping("/api/student-exam/{id}")
    public ResponseEntity<Void> deleteStudentExam(@PathVariable Long id) {
        studentExamService.deleteStudentExam(id);
        return ResponseEntity.noContent().build();
    }
}
