package org.example.educlass.exam.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.example.educlass.exam.dto.StudentLectureRequest;
import org.example.educlass.exam.dto.StudentLectureResponse;
import org.example.educlass.exam.service.StudentLectureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class StudentLectureApiController {

    private final StudentLectureService studentLectureService;

    @Operation(summary = "학생 강의 생성", description = "학생에게 강의를 부여합니다.")
    @PostMapping("/api/student-lecture")
    public ResponseEntity<StudentLectureResponse> createStudentLecture(@RequestBody StudentLectureRequest studentLectureRequest) {

        StudentLectureResponse studentLecture = studentLectureService.createStudentLecture(studentLectureRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(studentLecture);
    }

    @Operation(summary = "학생 강의 전체 조회", description = "학생별 강의 전체를 조회합니다. 하지만 필요가 없을 듯 함")
    @GetMapping("/api/student-lectures")
    public ResponseEntity<List<StudentLectureResponse>> getAllStudentLectures() {
        List<StudentLectureResponse> studentLectures = studentLectureService.getAllStudentLectures();

        return ResponseEntity.ok(studentLectures);
    }

    @Operation(summary = "학생 강의 전체 조회", description = "학생별 강의 전체를 조회합니다.")
    @GetMapping("/api/student-lectures/{studentId}")
    public ResponseEntity<List<StudentLectureResponse>> getStudentLectureByStudentId(@PathVariable Long studentId) {
        List<StudentLectureResponse> studentLectures = studentLectureService.getStudentLectureByStudentId(studentId)
                .stream()
                .map(studentLecture -> new StudentLectureResponse(
                        studentId,
                        studentLecture.getLectureId(),
                        studentLecture.getProgress()
                ))
                .toList();

        return ResponseEntity.ok(studentLectures);
    }

    @Operation(summary = "학생 강의 id 별 조회", description = "id별 학생 강의를 조회합니다.")
    @GetMapping("/api/student-lecture/{id}")
    public ResponseEntity<StudentLectureResponse> getStudentLectureById(@PathVariable Long id) {
        StudentLectureResponse studentLecture = studentLectureService.getStudentLectureById(id);

        return ResponseEntity.ok(studentLecture);
    }

    @Operation(summary = "학생 강의 id별 삭제", description = "id별 학생 강의를 삭제합니다.")
    @DeleteMapping("/api/student-lecture/{id}")
    public ResponseEntity<Void> deleteStudentLectureById(@PathVariable Long id) {
        studentLectureService.deleteStudentLecture(id);

        return ResponseEntity.noContent().build();
    }

}
