package org.example.educlass.member.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "DashBoard View API", description = "학생 대시보드 API")
@RestController
@RequiredArgsConstructor
public class DashBoardViewController {
}
