package org.example.educlass.exam.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.educlass.ProblemSet.domain.Problem;
import org.example.educlass.ProblemSet.domain.ProblemSet;
import org.example.educlass.ProblemSet.repository.ProblemSetRepository;
import org.example.educlass.exam.domain.Completed;
import org.example.educlass.exam.domain.StudentExam;
import org.example.educlass.exam.domain.StudentExamResult;
import org.example.educlass.exam.domain.StudentLecture;
import org.example.educlass.exam.dto.StudentExamAnswerDto;
import org.example.educlass.exam.dto.StudentExamMarkRequest;
import org.example.educlass.exam.dto.StudentExamRequest;
import org.example.educlass.exam.dto.StudentExamResponse;
import org.example.educlass.exam.dto.StudentExamSubmissionDto;
import org.example.educlass.exam.repository.StudentExamRepository;
import org.example.educlass.exam.repository.StudentExamResultRepository;
import org.example.educlass.exam.repository.StudentLectureRepository;
import org.example.educlass.member.domain.Student;
import org.example.educlass.member.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentExamService {

    private final StudentExamRepository studentExamRepository;
    private final StudentExamResultRepository studentExamResultRepository;
    private final StudentRepository studentRepository;
    private final StudentLectureRepository studentLectureRepository;
    private final ProblemSetRepository problemSetRepository;

    public StudentExamResponse createStudentExam(StudentExamRequest studentExamRequest) {

        StudentExam studentExam = new StudentExam();
        Student student = studentRepository.findById(studentExamRequest.getStudentId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid studentId: " + studentExamRequest.getStudentId()));
        StudentLecture studentLecture = studentLectureRepository.findById(studentExamRequest.getStudentLectureId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid studentLectureId: " + studentExamRequest.getStudentLectureId()));
        ProblemSet problemSet = problemSetRepository.findById(studentExamRequest.getProblemSetId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid problemSetId: " + studentExamRequest.getProblemSetId()));
        studentExam.setCompleted(Completed.N);

        studentExam.setStudent(student);
        studentExam.setProblemSet(problemSet);
        studentExam.setStudentLecture(studentLecture);
        studentExamRepository.save(studentExam);

        return new StudentExamResponse(studentExam);
    }

    @Transactional
    public void deleteStudentExam(Long id) {
        StudentExam studentExam = studentExamRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid studentId: " + id));

        studentExamRepository.delete(studentExam);
    }

    public StudentExamResponse getStudentExamById(Long id) {
        StudentExam studentExam = studentExamRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("StudentExam not found with id: " + id));

        return new StudentExamResponse(studentExam);
    }

    public List<StudentExamResponse> getAllStudentExams() {

        return studentExamRepository.findAll()
                .stream()
                .map(StudentExamResponse::new)
                .toList();
    }

    @Transactional
    public void processStudentExamSubmission(Long studentExamId, StudentExamSubmissionDto submissionDto) {
        StudentExam studentExam = studentExamRepository.findById(studentExamId)
                .orElseThrow(() -> new EntityNotFoundException("StudentExam not found with id: " + studentExamId));
        ProblemSet problemSet = problemSetRepository.findById(studentExam.getProblemSet().getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid problemSetId: " + studentExam.getProblemSet().getId()));

        int score = 0;
        List<StudentExamResult> examResults = new ArrayList<>();

        for (StudentExamAnswerDto answerDto : submissionDto.getStudentAnswers()) {
            Problem problem = problemSet.getProblems().stream()
                    .filter(p -> p.getId().equals(answerDto.getProblemId()))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("문제를 찾을 수 없습니다."));

            boolean isCorrect = problem.getAnswer().trim().equalsIgnoreCase(answerDto.getAnswer().trim());
            if (isCorrect) {
                score++;
            }

            // 정오표 저장
            StudentExamResult examResult = new StudentExamResult();
            examResult.setStudentExam(studentExam);
            examResult.setProblem(problem);
            examResult.setStudentAnswer(answerDto.getAnswer());
            examResult.setIsCorrect(isCorrect);
            examResults.add(examResult);
        }

        studentExam.setScore(score);
        studentExam.setCompleted(Completed.Y);
        studentExamRepository.save(studentExam);
        studentExamResultRepository.saveAll(examResults);
    }

    @Transactional
    public void markStudentExam(Long id, StudentExamMarkRequest request) {
        StudentExam studentExam = studentExamRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("StudentExam not found with id: " + id));
        List<StudentExamResult> examResults = studentExam.getStudentExamResults();

        for (StudentExamAnswerDto studentAnswer : request.getStudentAnswers()) {
            examResults.stream()
                    .filter(result -> result.getProblem().getId().equals(studentAnswer.getProblemId()))
                    .forEach(result -> result.setStudentAnswer(studentAnswer.getAnswer()));
        }

        studentExamRepository.save(studentExam);
        studentExamResultRepository.saveAll(examResults);
    }

    public StudentExamResponse findByStudentIdAndStudentLectureId(Long studentId, Long studentLectureId) {
        StudentExam studentExam = studentExamRepository.findByStudentIdAndStudentLectureId(studentId, studentLectureId)
                .orElseThrow(() -> new EntityNotFoundException("StudentExam not found with id: " + studentId));

        return new StudentExamResponse(studentExam);
    }
}
