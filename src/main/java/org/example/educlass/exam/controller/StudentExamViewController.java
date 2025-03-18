package org.example.educlass.exam.controller;

import lombok.RequiredArgsConstructor;
import org.example.educlass.ProblemSet.domain.ProblemSet;
import org.example.educlass.ProblemSet.repository.ProblemSetRepository;
import org.example.educlass.exam.domain.StudentExam;
import org.example.educlass.exam.service.StudentExamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class StudentExamViewController {

    private final StudentExamService studentExamService;
    private final ProblemSetRepository problemSetRepository;

    @GetMapping("/exam_results")
    public String getAllExamResult(Model model) {
        List<StudentExam> studentExams = studentExamService.getAllStudentExams();
        model.addAttribute("studentExams", studentExams);

        return "teacher/examResult";
    }

    @GetMapping("/student_exam/{id}")
    public String getStudentExam(@PathVariable Long id, Model model) {
        StudentExam studentExam = studentExamService.getStudentExamById(id);
        model.addAttribute("studentExam", studentExam);
        ProblemSet problemSet = problemSetRepository.findByIdWithProblems(studentExam.getProblemSet().getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid problem set ID"));

        studentExam.setProblemSet(problemSet);

        return "teacher/studentExam";
    }
}

