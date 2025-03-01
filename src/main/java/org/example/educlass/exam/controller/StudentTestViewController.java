package org.example.educlass.exam.controller;

import lombok.RequiredArgsConstructor;
import org.example.educlass.exam.domain.StudentTest;
import org.example.educlass.exam.service.StudentTestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class StudentTestViewController {

    private final StudentTestService studentTestService;

    @GetMapping("/testResults")
    public String getAllTestResult(Model model) {
        List<StudentTest> studentTests = studentTestService.getAllStudentTests();
        model.addAttribute("studentTests", studentTests);

        return "testResult";
    }
}
