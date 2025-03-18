package org.example.educlass.member.controller;

import lombok.RequiredArgsConstructor;
import org.example.educlass.member.domain.Student;
import org.example.educlass.member.dto.StudentListViewResponse;
import org.example.educlass.member.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class StudentViewController {

    private final StudentService studentService;

//    @GetMapping("/students")
//    public String getAllStudents(Model model) {
//        List<StudentListViewResponse> students = studentService.findAllStudents().stream()
//                .map(StudentListViewResponse::new)
//                .toList();
//        model.addAttribute("students", students);
//        return "studentList";
//    }

    @GetMapping("/students/{id}")
    public String getStudentById(@PathVariable() Long id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", new StudentListViewResponse(student));

        return "student";

    }

    @GetMapping("/students")
    public String getPagedStudents(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            Model model) {

        Page<StudentListViewResponse> studentPage = studentService.findAllStudentsPage(page, size)
                .map(StudentListViewResponse::new);

        model.addAttribute("students", studentPage.getContent()); // 학생 목록
        model.addAttribute("currentPage", studentPage.getNumber()); // 현재 페이지
        model.addAttribute("totalPages", studentPage.getTotalPages()); // 전체 페이지 수
        model.addAttribute("totalItems", studentPage.getTotalElements()); // 전체 데이터 개수

        return "teacher/studentList";
    }

//    @GetMapping("/articles/{id}")
//    public String getArticle(@PathVariable Long id, Model model) {
//        Article article = blogService.findById(id);
//        model.addAttribute("article", new ArticleViewResponse(article));
//
//        boolean canModify = article.getCreatedAt().
//                isAfter(LocalDateTime.now().minusDays(10));
//        model.addAttribute("canModify", canModify);
//
//        boolean canModifyAlert = article.getCreatedAt().isAfter(LocalDateTime.now().minusDays(10)) &&
//                article.getCreatedAt().isBefore(LocalDateTime.now().minusDays(9).plusDays(1));
//
//        model.addAttribute("canModifyAlert", canModifyAlert);
//
//        return "article";
//    }

}
