package org.example.educlass.member.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "certification")
public class Certification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false, unique = true, length = 50)
    private String email;

    @Column(nullable = false, length = 255)
    private String password;

    @Builder
    public Certification(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void updateUser(String email, String password) {
        this.email = email;
        this.password = password;
    }

}