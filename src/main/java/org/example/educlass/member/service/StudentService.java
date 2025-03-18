package org.example.educlass.member.service;

import lombok.RequiredArgsConstructor;
import org.example.educlass.member.domain.Student;
import org.example.educlass.member.dto.AddStudentRequest;
import org.example.educlass.member.repository.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Student createStudent(AddStudentRequest addStudentRequest) {

        return studentRepository.save(addStudentRequest.toEntity());
    }

    public List<Student> findAllStudents() {

        return studentRepository.findAll();
    }

    public Page<Student> findAllStudentsPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return studentRepository.findAll(pageable);
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not found: " + id));
    }

    public Student updateStudentById(Long id, AddStudentRequest addStudentRequest) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not found: " + id));

        student.updateStudent(addStudentRequest.toEntity());

        return student;
    }

    public void deleteStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not found: " + id));
        studentRepository.delete(student);
    }
}
