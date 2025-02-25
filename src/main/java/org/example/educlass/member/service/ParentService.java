//package org.example.educlass.member.service;
//
//import lombok.RequiredArgsConstructor;
//import org.example.educlass.member.domain.Parent;
//import org.example.educlass.member.domain.Student;
//import org.example.educlass.member.domain.User;
//import org.example.educlass.member.domain.Usertype;
//import org.example.educlass.member.dto.AddParentRequest;
//import org.example.educlass.member.repository.ParentRepository;
//import org.springframework.stereotype.Service;
//
//@RequiredArgsConstructor
//@Service
//public class ParentService {
//
//    private final ParentRepository parentRepository;
//
//    public Student createStudent(User user, AddParentRequest addParentRequest) {
//        if (user.getUsertype() != Usertype.PARENT) {
//            throw new IllegalArgumentException("해당 유저는 학부모가 아닙니다.");
//        }
//        Parent parent = parentRepository.save(addParentRequest);
//        parent.setUser(user);
//
//        return parent;
//    }
//}
