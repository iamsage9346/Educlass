package org.example.educlass.member.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.educlass.member.domain.Student;
import org.example.educlass.member.dto.StudentDashBoardResponse;
import org.example.educlass.member.dto.StudentProfileResponse;
import org.example.educlass.member.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Tag(name = "DashBoard View API", description = "학생 대시보드 API")
@Controller
@RequiredArgsConstructor
public class DashBoardViewController {

    private final StudentService studentService;

    @GetMapping("/student-dashboard/{studentId}")
    public String studentDashboard(@PathVariable() Long studentId, Model model) {
        Student student = studentService.getStudentById(studentId);
        StudentDashBoardResponse studentDashBoardResponse = new StudentDashBoardResponse(
                student.getId(), student.getName()
        );

        model.addAttribute("student", studentDashBoardResponse);

        return "student/dashBoard";
    }

    @GetMapping("/student-profile/{studentId}")
    public String studentProfile(@PathVariable() Long studentId, Model model) {
        StudentProfileResponse studentProfileResponse = studentService.getStudentProfileById(studentId);

        model.addAttribute("student", studentProfileResponse);

        return "student/myPage";
    }


}
