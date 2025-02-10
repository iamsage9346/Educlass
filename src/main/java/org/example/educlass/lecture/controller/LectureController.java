package org.example.educlass.lecture.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.example.educlass.lecture.domain.Lecture;
import org.example.educlass.lecture.dto.LectureRequest;
import org.example.educlass.lecture.dto.LectureResponse;
import org.example.educlass.lecture.service.LectureService;
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
public class LectureController {

    private final LectureService lectureService;

    @Operation(summary = "강의 생성", description = "grade, chapter에 맞는 강의를 생성합니다.")
    @PostMapping("/api/lecture")
    public ResponseEntity<LectureResponse> createLecture(@RequestBody LectureRequest lectureRequest) {
        Lecture lecture = lectureService.createLecture(lectureRequest);

        return ResponseEntity.ok(new LectureResponse(lecture));
    }

    @Operation(summary = "강의 생성", description = "grade, chapter에 맞는 강의를 생성합니다.")
    @GetMapping("/api/lecture/{id}")
    public ResponseEntity<LectureResponse> getLectureById(@PathVariable Long id) {

        Lecture lecture = lectureService.getLectureById(id);
        return ResponseEntity.ok(new LectureResponse(lecture));
    }

    @Operation(summary = "강의 생성", description = "grade, chapter에 맞는 강의를 생성합니다.")
    @GetMapping("/api/lecture")
    public ResponseEntity<List<LectureResponse>> getAllLectures() {
        List<LectureResponse> lectures = lectureService.getAllLectures()
                .stream()
                .map(LectureResponse::new)
                .toList();

        return ResponseEntity.ok().body(lectures);
    }

    @Operation(summary = "강의 생성", description = "grade, chapter에 맞는 강의를 생성합니다.")
    @DeleteMapping("/api/lecture/{id}")
    public ResponseEntity<Void> deleteLecture(@PathVariable Long id) {
        lectureService.deleteLectureById(id);

        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "강의 생성", description = "grade, chapter에 맞는 강의를 생성합니다.")
    @PutMapping("/api/lecture/{id}")
    public ResponseEntity<LectureResponse> updateLecture(@PathVariable Long id, @RequestBody LectureRequest lectureRequest) {

        Lecture lecture = lectureService.updateLecture(id, lectureRequest);

        return ResponseEntity.ok(new LectureResponse(lecture));
    }

}
