package org.example.educlass.exam.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.educlass.ProblemSet.domain.ProblemSet;
import org.example.educlass.ProblemSet.dto.ProblemSetRequest;
import org.example.educlass.ProblemSet.service.ProblemSetService;
import org.example.educlass.exam.domain.StudentTest;
import org.example.educlass.exam.domain.Test;
import org.example.educlass.exam.dto.StudentTestMarkRequest;
import org.example.educlass.exam.dto.StudentTestRequest;
import org.example.educlass.exam.repository.StudentTestRepository;
import org.example.educlass.exam.repository.TestRepository;
import org.example.educlass.member.domain.Student;
import org.example.educlass.member.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentTestService {

    private final StudentTestRepository studentTestRepository;
    private final StudentRepository studentRepository;
    private final TestRepository testRepository;
    private final ProblemSetService problemSetService;

    // 학생 시험 생성
    public StudentTest createStudentTest(StudentTestRequest studentTestRequest) {
        Long studentId = studentTestRequest.getStudentId();
        Long testId = studentTestRequest.getTestId();
        int chapter = studentTestRequest.getChapter();
        int grade = studentTestRequest.getGrade();

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new EntityNotFoundException("Student not found with id: " + studentId));
        Test test = testRepository.findById(testId)
                .orElseThrow(() -> new EntityNotFoundException("Test not found with id: " + testId));

        StudentTest studentTest = new StudentTest();
        studentTest.setStudent(student);
        studentTest.setTest(test);
        studentTest.setScore(0);
        studentTest.setCompleted(false);

        ProblemSet problemSet = problemSetService.createProblemSet(new ProblemSetRequest(testId, chapter, grade));
        studentTest.setProblemSet(problemSet);

        return studentTestRepository.save(studentTest);
    }

    // 학생 시험 삭제
    public void deleteStudentTest(Long id) {
        studentTestRepository.deleteById(id);
    }

    // 학생 시험 개별 조회
    public StudentTest getStudentTestById(Long id) {
        return studentTestRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Student not found with id: " + id));
    }

    // 학생 시험 채점
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
    }

    // 학생 시험 응시
    public void takeStudentTest(Long id, StudentTestRequest request) {
        StudentTest studentTest = getStudentTestById(id);
        ZonedDateTime startTime = studentTest.getCreatedAt();
        if (ZonedDateTime.now().minusHours(1).isAfter(startTime)) {

        }
    }

}
