package org.example.educlass.exam.controller;

import lombok.RequiredArgsConstructor;
import org.example.educlass.ProblemSet.dto.ProblemSetResponse;
import org.example.educlass.ProblemSet.service.ProblemSetService;
import org.example.educlass.exam.dto.StudentExamResponse;
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
    private final ProblemSetService problemSetService;

    @GetMapping("/exam_results")
    public String getAllExamResult(Model model) {
        List<StudentExamResponse> studentExams = studentExamService.getAllStudentExams();
        model.addAttribute("studentExams", studentExams);

        return "teacher/examResult";
    }

    @GetMapping("/student_exam/{studentId}/{studentLectureId}")
    public String getStudentExam(@PathVariable Long studentId,
                                 @PathVariable Long studentLectureId,
                                 Model model) {

        StudentExamResponse studentExam = studentExamService.findByStudentIdAndStudentLectureId(studentId, studentLectureId);

        Long problemSetId = studentExam.getProblemSetId();
        ProblemSetResponse problemSet = problemSetService.findProblemSetById(problemSetId);

        model.addAttribute("studentExam", studentExam);
        model.addAttribute("problemSet", problemSet);

        return "student/studentExam";
    }
}

