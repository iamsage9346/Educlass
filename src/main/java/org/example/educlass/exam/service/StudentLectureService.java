package org.example.educlass.exam.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.educlass.exam.domain.Lecture;
import org.example.educlass.exam.domain.StudentLecture;
import org.example.educlass.exam.dto.StudentLectureRequest;
import org.example.educlass.exam.dto.StudentLectureResponse;
import org.example.educlass.exam.dto.StudentLectureViewResponse;
import org.example.educlass.exam.repository.LectureRepository;
import org.example.educlass.exam.repository.StudentLectureRepository;
import org.example.educlass.member.domain.Student;
import org.example.educlass.member.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentLectureService {
    private final StudentLectureRepository studentLectureRepository;
    private final LectureRepository lectureRepository;
    private final StudentRepository studentRepository;

    @Transactional
    public StudentLectureResponse createStudentLecture(StudentLectureRequest studentLectureRequest) {
        Lecture lecture = lectureRepository.findById(studentLectureRequest.getLectureId())
                .orElseThrow(() -> new EntityNotFoundException("Lecture not found"));

        Student student = studentRepository.findById(studentLectureRequest.getStudentId())
                .orElseThrow(() -> new EntityNotFoundException("Student not found"));

        StudentLecture studentLecture = new StudentLecture(lecture, student);
        studentLecture.setProgress(0);

        studentLectureRepository.save(studentLecture);
        return new StudentLectureResponse(studentLecture);
    }

    @Transactional
    public List<StudentLectureResponse> getAllStudentLectures() {
        return studentLectureRepository.findAll()
                .stream()
                .map(StudentLectureResponse::new)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<StudentLectureViewResponse> getStudentLectureByStudentId(Long studentId) {
        return studentLectureRepository.findByStudentId(studentId)
                .stream()
                .map(studentLecture -> new StudentLectureViewResponse(
                        studentLecture.getStudent().getId(),
                        studentLecture.getLecture().getId(),
                        studentLecture.getProgress(),
                        studentLecture.getLecture().getName()
                ))
                .toList();
    }

    public StudentLectureResponse getStudentLectureById(Long studentLectureId) {
        StudentLecture studentLecture = studentLectureRepository.findById(studentLectureId)
                .orElseThrow(() -> new EntityNotFoundException("StudentLecture not found with id: " + studentLectureId));

        return new StudentLectureResponse(studentLecture);
    }

    public void deleteStudentLecture(Long studentLectureId) {
        studentLectureRepository.deleteById(studentLectureId);
    }
}
