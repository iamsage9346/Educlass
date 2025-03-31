package org.example.educlass.exam.controller;

import lombok.RequiredArgsConstructor;
import org.example.educlass.exam.dto.StudentLectureViewResponse;
import org.example.educlass.exam.service.StudentLectureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class StudentLectureViewController {

    private final StudentLectureService studentLectureService;

    @GetMapping("/student-dashboard/{studentId}/lectures")
    public String getAllStudentLecture(@PathVariable Long studentId, Model model) {
        List<StudentLectureViewResponse> studentLecturesDto = studentLectureService.getStudentLectureByStudentId(studentId)
                .stream()
                .map(studentLecture -> new StudentLectureViewResponse(
                        studentId,
                        studentLecture.getLectureId(),
                        studentLecture.getProgress(),
                        studentLecture.getLectureName()
                ))
                .toList();

        model.addAttribute("studentLectures", studentLecturesDto);

        return "student/lectures";
    }

}
