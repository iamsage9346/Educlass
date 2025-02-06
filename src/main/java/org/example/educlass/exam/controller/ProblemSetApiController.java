package org.example.educlass.exam.controller;

import lombok.RequiredArgsConstructor;
import org.example.educlass.exam.dto.ProblemSetRequest;
import org.example.educlass.exam.dto.ProblemSetResponse;
import org.example.educlass.exam.service.ProblemSetService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ProblemSetApiController {

    private final ProblemSetService problemSetService;

    @PostMapping("/api/problem-set")
    public ProblemSetResponse createProblemSet (@RequestBody ProblemSetRequest problemSetRequest) {
        return problemSetService.createProblemSet(problemSetRequest);
    }
}
