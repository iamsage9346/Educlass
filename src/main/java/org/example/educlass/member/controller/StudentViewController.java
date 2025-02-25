package org.example.educlass.member.controller;

import lombok.RequiredArgsConstructor;
import org.example.educlass.member.dto.StudentListViewResponse;
import org.example.educlass.member.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class StudentViewController {

    private final StudentService studentService;

    @GetMapping("/students")
    public String getAllStudents(Model model) {
        List<StudentListViewResponse> students = studentService.findAllStudents().stream()
                .map(StudentListViewResponse::new)
                .toList();
        model.addAttribute("students", students);
        return "studentList";
    }

}
