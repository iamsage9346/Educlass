package org.example.educlass.exam.controller;

import lombok.RequiredArgsConstructor;
import org.example.educlass.ProblemSet.domain.ProblemSet;
import org.example.educlass.ProblemSet.repository.ProblemSetRepository;
import org.example.educlass.exam.domain.StudentTest;
import org.example.educlass.exam.service.StudentTestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class StudentTestViewController {

    private final StudentTestService studentTestService;
    private final ProblemSetRepository problemSetRepository;

    @GetMapping("/test_results")
    public String getAllTestResult(Model model) {
        List<StudentTest> studentTests = studentTestService.getAllStudentTests();
        model.addAttribute("studentTests", studentTests);

        return "testResult";
    }

    @GetMapping("/student_test/{id}")
    public String getStudentTest(@PathVariable Long id, Model model) {
        StudentTest studentTest = studentTestService.getStudentTestById(id);
        model.addAttribute("studentTest", studentTest);
        ProblemSet problemSet = problemSetRepository.findByIdWithProblems(studentTest.getProblemSet().getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid problem set ID"));

        studentTest.setProblemSet(problemSet); // 강제로 문제 리스트를 포함하도록 설정

        return "studentTest";
    }
}

