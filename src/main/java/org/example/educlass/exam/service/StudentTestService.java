package org.example.educlass.exam.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.educlass.ProblemSet.domain.Problem;
import org.example.educlass.ProblemSet.domain.ProblemSet;
import org.example.educlass.ProblemSet.repository.ProblemRepository;
import org.example.educlass.ProblemSet.service.ProblemSetService;
import org.example.educlass.exam.domain.Completed;
import org.example.educlass.exam.domain.StudentTest;
import org.example.educlass.exam.domain.StudentTestResult;
import org.example.educlass.exam.dto.StudentTestAnswerDto;
import org.example.educlass.exam.dto.StudentTestMarkRequest;
import org.example.educlass.exam.dto.StudentTestRequest;
import org.example.educlass.exam.dto.StudentTestSubmissionDto;
import org.example.educlass.exam.repository.StudentTestRepository;
import org.example.educlass.exam.repository.StudentTestResultRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentTestService {

    private final StudentTestRepository studentTestRepository;
    private final ProblemSetService problemSetService;
    private final StudentTestResultRepository studentTestResultRepository;
    private final ProblemRepository problemRepository;

    public StudentTest createStudentTest(StudentTestRequest studentTestRequest) {
        StudentTest studentTest = studentTestRequest.toEntity();
        studentTest.setCompleted(Completed.N);

        // 문제지 자동 생성
        problemSetService.createProblemSet(studentTest.getId());

        return studentTestRepository.save(studentTest);
    }

    @Transactional
    public void deleteStudentTest(Long id) {
        StudentTest studentTest = getStudentTestById(id);
        studentTestRepository.delete(studentTest);
    }

    public StudentTest getStudentTestById(Long id) {
        return studentTestRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("StudentTest not found with id: " + id));
    }

    public List<StudentTest> getAllStudentTests() {
        return studentTestRepository.findAll();
    }

    @Transactional
    public void processStudentTestSubmission(Long studentTestId, StudentTestSubmissionDto submissionDto) {
        StudentTest studentTest = getStudentTestById(studentTestId);
        ProblemSet problemSet = studentTest.getProblemSet();
        int score = 0;
        List<StudentTestResult> testResults = new ArrayList<>();

        for (StudentTestAnswerDto answerDto : submissionDto.getStudentAnswers()) {
            Problem problem = problemSet.getProblems().stream()
                    .filter(p -> p.getId().equals(answerDto.getProblemId()))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("문제를 찾을 수 없습니다."));

            boolean isCorrect = problem.getAnswer().trim().equalsIgnoreCase(answerDto.getAnswer().trim());
            if (isCorrect) {
                score++;
            }

            // 정오표 저장
            StudentTestResult testResult = new StudentTestResult();
            testResult.setStudentTest(studentTest);
            testResult.setProblem(problem);
            testResult.setStudentAnswer(answerDto.getAnswer());
            testResult.setIsCorrect(isCorrect);
            testResults.add(testResult);
        }

        studentTest.setScore(score);
        studentTest.setCompleted(Completed.Y);
        studentTestRepository.save(studentTest);
        studentTestResultRepository.saveAll(testResults);
    }

    @Transactional
    public void markStudentTest(Long id, StudentTestMarkRequest request) {
        StudentTest studentTest = getStudentTestById(id);
        List<StudentTestResult> testResults = studentTest.getStudentTestResults();

        for (StudentTestAnswerDto studentAnswer : request.getStudentAnswers()) {
            testResults.stream()
                    .filter(result -> result.getProblem().getId().equals(studentAnswer.getProblemId()))
                    .forEach(result -> result.setStudentAnswer(studentAnswer.getAnswer()));
        }

        studentTestRepository.save(studentTest);
        studentTestResultRepository.saveAll(testResults);
    }
}
