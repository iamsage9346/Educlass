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
import org.example.educlass.exam.domain.StudentTest;

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

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    // 학년
    @Column(nullable = false)
    private int grade;

    // 반
    @Column(nullable = false)
    private int classNum;

    @Column(nullable = false)
    private int gender;  // 성별 (0 = male, 1 = female)

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<StudentTest> studentTests;  // 학생이 응시한 시험 목록

//    @OneToMany(mappedBy = "lecture", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Lecture> lectures;  // 학생이 응시한 시험 목록

    @Builder
    public Student(User user, int grade, int classNum, int gender) {
        this.user = user;
        this.grade = grade;
        this.classNum = classNum;
        this.gender = gender;
    }

    public void updateStudent(Student student) {
        this.user = student.getUser();
        this.grade = student.getGrade();
        this.classNum = student.getClassNum();
        this.gender = student.getGender();
    }
}
