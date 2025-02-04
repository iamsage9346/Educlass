package org.example.educlass.member.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.educlass.member.domain.Usertype;

@Getter
@Setter
public class AddUserRequest {
    private String name;      // 회원 이름
    private String phone;     // 전화번호
    private Usertype type;    // 회원 유형 (STUDENT, PARENT, ADMIN)
    private String email;     // 로그인 이메일
    private String password;  // 로그인 비밀번호
    private String role;
}
