package org.example.educlass.member.controller;

import lombok.RequiredArgsConstructor;
import org.example.educlass.member.service.UserService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
}
