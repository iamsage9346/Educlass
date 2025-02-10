package org.example.educlass.lecture.service;

import lombok.RequiredArgsConstructor;
import org.example.educlass.lecture.domain.Lecture;
import org.example.educlass.lecture.dto.LectureRequest;
import org.example.educlass.lecture.repository.LectureRepository;
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

    public Lecture getLectureById(Long id) {
        return lectureRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Lecture not found: " + id));
    }

    public List<Lecture> getAllLectures() {
        return lectureRepository.findAll();
    }

    @Transactional
    public void deleteLectureById(Long id) {
        if (!lectureRepository.existsById(id)) {
            throw new IllegalArgumentException("Lecture not found: " + id);
        }
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
