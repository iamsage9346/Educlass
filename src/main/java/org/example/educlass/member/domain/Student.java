package org.example.educlass.member.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.educlass.exam.domain.StudentExam;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 100, unique = true)
    private String phone;

    @Column(nullable = false)
    private int grade;

    @Column(name="class_num", nullable = false)
    private int classNum;

    @Column(nullable = false)
    private int gender;  // 성별 (0 = male, 1 = female)

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "certification_id")
    private Certification certification;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<StudentExam> studentExams;  // 학생이 응시한 시험 목록

    @Builder
    public Student(String name, String phone, int grade, int classNum, int gender, Certification certification) {
        this.name = name;
        this.phone = phone;
        this.grade = grade;
        this.classNum = classNum;
        this.gender = gender;
        this.certification = certification;
    }

    public void updateStudent(Student student) {
        this.name = student.getName();
        this.phone = student.getPhone();
        this.grade = student.getGrade();
        this.classNum = student.getClassNum();
        this.gender = student.getGender();
        this.certification = student.getCertification();
    }
}
