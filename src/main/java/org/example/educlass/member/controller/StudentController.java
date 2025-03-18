package org.example.educlass.member.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.educlass.member.domain.Student;
import org.example.educlass.member.dto.AddStudentRequest;
import org.example.educlass.member.dto.StudentResponse;
import org.example.educlass.member.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Student API", description = "학생 관련 API")
@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @Operation(summary = "학생 생성", description = "새로운 학생을 생성합니다.")
    @PostMapping("/api/student")
    public ResponseEntity<StudentResponse> createStudent(@RequestBody AddStudentRequest studentRequest) {
        Student student = studentService.createStudent(studentRequest);

        StudentResponse studentResponse = new StudentResponse(student);

        return ResponseEntity.status(HttpStatus.CREATED).body(studentResponse);
    }

    @Operation(summary = "학생 개별 조회", description = "id별 학생을 조회합니다.")
    @GetMapping("/api/student/{id}")
    public ResponseEntity<StudentResponse> getStudentById(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);

        return ResponseEntity.status(HttpStatus.OK).body(new StudentResponse(student));
    }

    @Operation(summary = "학생 전체 조회", description = "모든 학생을 조회합니다.")
    @GetMapping("/api/students")
    public ResponseEntity<List<StudentResponse>> findAllStudents() {
        List<StudentResponse> studentResponses = studentService.findAllStudents()
                .stream()
                .map(StudentResponse::new)
                .toList();

        return ResponseEntity.status(HttpStatus.OK).body(studentResponses);
    }

    @Operation(summary = "학생 전체 페이징 조회", description = "모든 학생을 페이징해서 조회합니다.")
    @GetMapping("/api/students/paged")
    public ResponseEntity<Page<StudentResponse>> findAllStudentsPageable(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Page<Student> studentPage = studentService.findAllStudentsPage(page, size);
        Page<StudentResponse> responsePage = studentPage.map(StudentResponse::new);

        return ResponseEntity.ok(responsePage);
    }

    @Operation(summary = "학생 정보 수정", description = "id별 학생을 수정합니다.")
    @PutMapping("/api/student/{id}")
    public ResponseEntity<StudentResponse> updateStudent(@PathVariable Long id, @RequestBody AddStudentRequest studentRequest) {
        Student studentResponse = studentService.updateStudentById(id, studentRequest);

        return ResponseEntity.ok(new StudentResponse(studentResponse));
    }

    @Operation(summary = "학생 정보 삭제", description = "id별 학생을 삭제합니다.")
    @DeleteMapping("/api/student/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);

        return ResponseEntity.noContent().build();
    }
}
