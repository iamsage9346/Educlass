package org.example.educlass.exam.service;

import lombok.RequiredArgsConstructor;
import org.example.educlass.exam.domain.Lecture;
import org.example.educlass.exam.dto.LectureRequest;
import org.example.educlass.exam.dto.LectureResponse;
import org.example.educlass.exam.repository.LectureRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LectureService {

    private final LectureRepository lectureRepository;

    // 강의 생성
    @Transactional
    public LectureResponse createLecture(LectureRequest lectureRequest) {
        Lecture lecture = lectureRepository.save(lectureRequest.toEntity());
        return new LectureResponse(lecture);
    }

    @Transactional
    public LectureResponse getLectureById(Long id) {
        Lecture lecture = lectureRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Lecture not found: " + id));

        return new LectureResponse(lecture);
    }

    @Transactional
    public List<LectureResponse> getAllLectures() {

        return lectureRepository.findAll()
                .stream()
                .map(LectureResponse::new)
                .toList();
    }

    @Transactional
    public void deleteLectureById(Long id) {
        lectureRepository.deleteById(id);
    }

    @Transactional
    public LectureResponse updateLecture(Long id, LectureRequest lectureRequest) {
        Lecture lecture = lectureRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Lecture not found: " + id));

        lecture.update(lectureRequest.getName(), lectureRequest.getLink(), lectureRequest.getChapter(), lectureRequest.getGrade());

        return new LectureResponse(lectureRepository.save(lecture));
    }
}
