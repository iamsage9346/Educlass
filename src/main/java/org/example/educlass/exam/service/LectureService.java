package org.example.educlass.exam.service;

import lombok.RequiredArgsConstructor;
import org.example.educlass.exam.domain.Lecture;
import org.example.educlass.exam.dto.LectureRequest;
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
    public Lecture createLecture(LectureRequest lectureRequest) {
        return lectureRepository.save(lectureRequest.toEntity());
    }

    @Transactional
    public Lecture getLectureById(Long id) {
        return lectureRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Lecture not found: " + id));
    }

    @Transactional
    public List<Lecture> getAllLectures() {
        return lectureRepository.findAll();
    }

    @Transactional
    public void deleteLectureById(Long id) {
        lectureRepository.deleteById(id);
    }

    @Transactional
    public Lecture updateLecture(Long id, LectureRequest lectureRequest) {
        Lecture lecture = lectureRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Lecture not found: " + id));

        lecture.update(lectureRequest.getName(), lectureRequest.getLink(), lectureRequest.getChapter(), lectureRequest.getGrade());
        return lecture;
    }
}
