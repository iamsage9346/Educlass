package org.example.educlass.member.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 100, unique = true)
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Usertype type;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Certification certification;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Authorization authorization;

    @Builder
    public User(String name, String phone, Usertype type) {
        this.name = name;
        this.phone = phone;
        this.type = type;
    }
}