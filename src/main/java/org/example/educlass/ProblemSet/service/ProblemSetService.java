package org.example.educlass.ProblemSet.service;

import lombok.RequiredArgsConstructor;
import org.example.educlass.ProblemSet.domain.Problem;
import org.example.educlass.ProblemSet.domain.ProblemSet;
import org.example.educlass.ProblemSet.domain.ProblemSetToProblem;
import org.example.educlass.ProblemSet.repository.ProblemRepository;
import org.example.educlass.ProblemSet.repository.ProblemSetRepository;
import org.example.educlass.ProblemSet.repository.ProblemSetToProblemRepository;
import org.example.educlass.exam.domain.StudentExam;
import org.example.educlass.exam.repository.StudentExamRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProblemSetService {

    private final ProblemSetRepository problemSetRepository;
    private final ProblemRepository problemRepository;
    private final StudentExamRepository studentExamRepository;
    private final ProblemSetToProblemRepository problemSetToProblemRepository;

    // 특정 챕터 문제 랜덤 10개 생성
    @Transactional
    public ProblemSet createProblemSet(Long studentExamId) {
        StudentExam studentExam = studentExamRepository.findById(studentExamId)
                .orElseThrow(() -> new IllegalArgumentException("StudentExam not found"));

        int chapter = studentExam.getChapter();
        int grade = studentExam.getGrade();

        // 조건에 맞는 문제 10개 랜덤 선택
        List<Problem> multipleChoiceQuestions = problemRepository.findRandomProblems(chapter, grade, "MULTIPLE_CHOICE", 5);
        List<Problem> shortAnswerQuestions = problemRepository.findRandomProblems(grade, chapter, "SHORT_ANSWER", 3);
        List<Problem> essayQuestions = problemRepository.findRandomProblems(grade, chapter, "ESSAY", 2);

        List<Problem> allProblems = new ArrayList<>();
        allProblems.addAll(multipleChoiceQuestions);
        allProblems.addAll(shortAnswerQuestions);
        allProblems.addAll(essayQuestions);
        Collections.shuffle(allProblems);

        // ProblemSet 생성 및 저장
        ProblemSet problemSet = new ProblemSet();
        problemSetRepository.save(problemSet);

        for (Problem problem : allProblems) {
            ProblemSetToProblem mapping = new ProblemSetToProblem();
            mapping.setProblemSet(problemSet);
            mapping.setProblem(problem);
            problemSetToProblemRepository.save(mapping);
        }

        return problemSet;
    }

    // 문제지 조회
    public ProblemSet findProblemSetById(Long id) {
        return problemSetRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("ProblemSet not found: " + id));

    }

    // 문제지 삭제
    @Transactional
    public void deleteProblemSet(Long id) {
        if (!problemSetRepository.existsById(id)) {
            throw new IllegalArgumentException("Problem set not found: " + id);
        }

        // 매핑된 문제들 모두 삭제
        problemSetToProblemRepository.deleteByProblemSet_Id(id);

        problemSetRepository.deleteById(id);
    }
}
