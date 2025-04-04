package org.example.educlass.exam.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.example.educlass.exam.dto.LectureRequest;
import org.example.educlass.exam.dto.LectureResponse;
import org.example.educlass.exam.service.LectureService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LectureApiController {

    private final LectureService lectureService;

    @Operation(summary = "강의 생성", description = "grade, chapter에 맞는 강의를 생성합니다.")
    @PostMapping("/api/lecture")
    public ResponseEntity<LectureResponse> createLecture(@RequestBody LectureRequest lectureRequest) {
        LectureResponse lecture = lectureService.createLecture(lectureRequest);

        return ResponseEntity.ok(lecture);
    }

    @Operation(summary = "강의 개별 조회", description = "id별 강의를 조회합니다.")
    @GetMapping("/api/lecture/{id}")
    public ResponseEntity<LectureResponse> getLectureById(@PathVariable Long id) {

        LectureResponse lecture = lectureService.getLectureById(id);
        return ResponseEntity.ok(lecture);
    }

    @Operation(summary = "강의 전체 조회", description = "강의 전체를 조회합니다.")
    @GetMapping("/api/lecture")
    public ResponseEntity<List<LectureResponse>> getAllLectures() {
        List<LectureResponse> lectures = lectureService.getAllLectures();

        return ResponseEntity.ok(lectures);
    }

    @Operation(summary = "강의 삭제", description = "id별 강의를 삭제합니다.")
    @DeleteMapping("/api/lecture/{id}")
    public ResponseEntity<Void> deleteLecture(@PathVariable Long id) {
        lectureService.deleteLectureById(id);

        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "강의 수정", description = "강의를 요청에 맞게 수정합니다.")
    @PutMapping("/api/lecture/{id}")
    public ResponseEntity<LectureResponse> updateLecture(@PathVariable Long id, @RequestBody LectureRequest lectureRequest) {

        LectureResponse lecture = lectureService.updateLecture(id, lectureRequest);

        return ResponseEntity.ok(lecture);
    }

}
