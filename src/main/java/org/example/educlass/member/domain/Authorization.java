//package org.example.educlass.member.domain;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.EnumType;
//import jakarta.persistence.Enumerated;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Table;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@Entity
//@Table(name = "authorization")
//public class Authorization {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(nullable = false) // studentId, adminId, parentId
//    private Long userId;
//
//    @Enumerated(EnumType.STRING)
//    private Usertype role;
//
//    @ManyToOne
//    @JoinColumn(name = "certification_id", nullable = false)
//    private Certification certification;
//}
