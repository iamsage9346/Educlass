package org.example.educlass.member.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.educlass.member.domain.User;
import org.example.educlass.member.domain.Usertype;

@Getter
@Setter
public class AddUserRequest {
    private String name;
    private String phone;
    private String email;
    private String password;
    private Usertype usertype;

    @Builder
    public User toEntity() {
        return User.builder()
                .name(name)
                .phone(phone)
                .email(email)
                .password(password)
                .usertype(usertype)
                .build();
    }
}
