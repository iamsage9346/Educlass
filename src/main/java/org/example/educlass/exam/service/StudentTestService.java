package org.example.educlass.exam.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.educlass.ProblemSet.domain.ProblemSet;
import org.example.educlass.ProblemSet.service.ProblemSetService;
import org.example.educlass.exam.domain.StudentTest;
import org.example.educlass.exam.dto.StudentTestMarkRequest;
import org.example.educlass.exam.dto.StudentTestRequest;
import org.example.educlass.exam.repository.StudentTestRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentTestService {

    private final StudentTestRepository studentTestRepository;
    private final ProblemSetService problemSetService;

    // 학생 시험 생성
    public StudentTest createStudentTest(StudentTestRequest studentTestRequest) {
        StudentTest studentTest = studentTestRequest.toEntity();

        ProblemSet problemSet = problemSetService.createProblemSet(new ProblemSetRequest(
                studentTest.getTest().getId(),
                studentTest.getTest().getLecture().getChapter(),
                studentTest.getTest().getLecture().getGrade()
        ));

        studentTest.setProblemSet(problemSet);

        return studentTestRepository.save(studentTest);
    }

    // 학생 시험 삭제
    @Transactional
    public void deleteStudentTest(Long id) {
        if (!studentTestRepository.existsById(id)) {
            throw new EntityNotFoundException("StudentTest not found with id: " + id);
        }
        studentTestRepository.deleteById(id);
    }

    // 학생 시험 개별 조회
    public StudentTest getStudentTestById(Long id) {
        return studentTestRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("StudentTest not found with id: " + id));
    }

    // 학생 시험 전체 조회
    public List<StudentTest> getAllStudentTests() {
        return studentTestRepository.findAll();
    }

    // 학생 시험 채점
    @Transactional
    public void markStudentTest(Long id, StudentTestMarkRequest request) {
        StudentTest studentTest = getStudentTestById(id);
        ProblemSet problemSet = studentTest.getProblemSet();
        int score = 0;

        List<String> answerSet = new ArrayList<>();
        problemSet.getProblems().forEach(problem -> answerSet.add(problem.getAnswer()));

        List<String> studentAnswerSet = request.getStudentAnswers();
        for (int i = 0; i < studentAnswerSet.size(); i++) {
            if (studentAnswerSet.get(i).equals(answerSet.get(i))) {
                score++;
            }
        }
        studentTest.setScore(score);
        studentTest.setCompleted(true);

        studentTestRepository.save(studentTest);
    }

    // 학생 시험 응시
    @Transactional
    public void takeStudentTest(Long id) {
        StudentTest studentTest = getStudentTestById(id);
        ZonedDateTime startTime = studentTest.getCreatedAt();
        if (ZonedDateTime.now().minusHours(1).isAfter(startTime)) {
            throw new IllegalStateException("시험 시간이 만료되었습니다.");
        }

        studentTestRepository.save(studentTest);
    }

}
