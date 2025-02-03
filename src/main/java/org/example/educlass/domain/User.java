package org.example.educlass.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
}