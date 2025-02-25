package org.example.educlass.member.service;

import lombok.RequiredArgsConstructor;
import org.example.educlass.ProblemSet.domain.Problem;
import org.example.educlass.member.domain.Student;
import org.example.educlass.member.domain.User;
import org.example.educlass.member.domain.Usertype;
import org.example.educlass.member.dto.AddStudentRequest;
import org.example.educlass.member.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Student createStudent(User user, AddStudentRequest addStudentRequest) {
        if (user.getUsertype() != Usertype.STUDENT) {
            throw new IllegalArgumentException("해당 유저는 학생이 아닙니다.");
        }
        Student student = studentRepository.save(addStudentRequest.toEntity());
        student.setUser(user);

        return student;
    }

    public List<Student> getAllStudents() {

        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not found: " + id));
    }

    public Student updateStudentById(Long id, AddStudentRequest addStudentRequest) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not found: " + id));

        student
    }
}
