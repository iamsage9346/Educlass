package org.example.educlass.ProblemSet.service;

import lombok.RequiredArgsConstructor;
import org.example.educlass.ProblemSet.domain.Problem;
import org.example.educlass.ProblemSet.domain.ProblemSet;
import org.example.educlass.ProblemSet.domain.ProblemType;
import org.example.educlass.ProblemSet.dto.ProblemSetRequest;
import org.example.educlass.ProblemSet.repository.ProblemRepository;
import org.example.educlass.ProblemSet.repository.ProblemSetRepository;
import org.example.educlass.exam.domain.Test;
import org.example.educlass.exam.repository.TestRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProblemSetService {

    private final ProblemSetRepository problemSetRepository;
    private final ProblemRepository problemRepository;
    private final TestRepository testRepository;

    // 특정 챕터 문제 랜덤 10개 생성
    @Transactional
    public ProblemSet createProblemSet(ProblemSetRequest problemSetRequest) {
        Test test = testRepository.findById(problemSetRequest.getTestId())
                .orElseThrow(() -> new IllegalArgumentException("시험 ID가 존재하지 않습니다."));
        int chapter = problemSetRequest.getChapter();
        int grade = problemSetRequest.getGrade();

        List<Problem> multipleChoiceQuestions = getRandomProblems(grade, chapter, ProblemType.MULTIPLE_CHOICE, 5);
        List<Problem> shortAnswerQuestions = getRandomProblems(grade, chapter, ProblemType.SHORT_ANSWER, 3);
        List<Problem> essayQuestions = getRandomProblems(grade, chapter, ProblemType.ESSAY, 2);

        List<Problem> allProblems = new ArrayList<>();
        allProblems.addAll(multipleChoiceQuestions);
        allProblems.addAll(shortAnswerQuestions);
        allProblems.addAll(essayQuestions);
        Collections.shuffle(allProblems); // 문제 섞기

        ProblemSet problemSet = new ProblemSet();
        problemSet.setTest(test);
        problemSet.setChapter(chapter);
        problemSet.setProblems(allProblems);

        // 6️⃣ 문제지 저장 후 반환
        return problemSetRepository.save(problemSet);
    }

    // 문제지 조회
    public ProblemSet findProblemSetById(Long id) {
        return problemSetRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("ProblemSet not found: " + id));
    }

    // 문제지 삭제
    @Transactional
    public void deleteProblemSet(Long problemSetId) {
        if (!problemSetRepository.existsById(problemSetId)) {
            throw new IllegalArgumentException("Problem set not found: " + problemSetId);
        }
        problemSetRepository.deleteById(problemSetId);
    }

    // 문제 타입별 랜덤 문제 조회
    private List<Problem> getRandomProblems(int grade, int chapter, ProblemType type, int count) {
        List<Problem> problems = problemRepository.findByGradeAndChapterAndType(grade, chapter, type);
        Collections.shuffle(problems);
        return problems.stream().limit(count).collect(Collectors.toList());
    }


}
