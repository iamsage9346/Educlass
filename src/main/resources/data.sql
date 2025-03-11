INSERT INTO student (name, phone, grade, class_num, gender) VALUES
('강지훈', '010-8693-1188', 3, 1, 1),
('윤하윤', '010-1347-7450', 3, 7, 0),
('강민수', '010-9153-2884', 3, 1, 1),
('최건우', '010-8156-9140', 3, 1, 0),
('이태윤', '010-8557-3721', 1, 3, 1),
('임건우', '010-5545-1887', 2, 6, 0),
('이건우', '010-7020-1352', 1, 6, 0),
('강민수', '010-1359-1776', 1, 1, 0),
('최지훈', '010-2953-1231', 3, 2, 1);

-- grade:3 인 챕터 별 강의
INSERT INTO lecture (id, name, grade, link, chapter) VALUES
(1, 'Mathematics', 3, 'https://www.naver.com/', 1),
(2, 'Science', 3, 'https://www.naver.com/', 2);

INSERT INTO student_lecture (id, student_id, lecture_id, progress) VALUES
(1, 1, 1, 100),
(2, 1, 2, 100);

-- 문제지 생성
INSERT INTO problem_set (id) VALUES (1), (2);

INSERT INTO student_test (id, student_id, student_lecture_id, problem_set_id, chapter, grade, completed, score) VALUES
(1, 1, 1, 1, 1, 3, 'N', 0), -- Algebra 시험
(2, 1, 2, 2, 2, 3, 'N', 0); -- Physics 시험

-- grade:3, chapter:1 problem
INSERT INTO problem (id, content, answer, problem_type, grade, chapter) VALUES
(1, 'content1', 'answer1', 'MULTIPLE_CHOICE', 3, 1),
(2, 'content2', 'answer2', 'MULTIPLE_CHOICE', 3, 1),
(3, 'content3', 'answer3', 'MULTIPLE_CHOICE', 3, 1),
(4, 'content4', 'answer4', 'MULTIPLE_CHOICE', 3, 1),
(5, 'content5', 'answer5', 'MULTIPLE_CHOICE', 3, 1),
(6, 'content6', 'answer6', 'MULTIPLE_CHOICE', 3, 1),
(7, 'content7', 'answer7', 'MULTIPLE_CHOICE', 3, 1),
(8, 'content8', 'answer8', 'MULTIPLE_CHOICE', 3, 1),
(9, 'content9', 'answer9', 'MULTIPLE_CHOICE', 3, 1),
(10, 'content10', 'answer10', 'MULTIPLE_CHOICE', 3, 1),
(11, 'content11', 'answer11', 'MULTIPLE_CHOICE', 3, 1),
(12, 'content12', 'answer12', 'MULTIPLE_CHOICE', 3, 1),
(13, 'content13', 'answer13', 'MULTIPLE_CHOICE', 3, 1),
(14, 'content14', 'answer14', 'MULTIPLE_CHOICE', 3, 1),
(15, 'content15', 'answer15', 'MULTIPLE_CHOICE', 3, 1),
(16, 'content16', 'answer16', 'SHORT_ANSWER', 3, 1),
(17, 'content17', 'answer17', 'SHORT_ANSWER', 3, 1),
(18, 'content18', 'answer18', 'SHORT_ANSWER', 3, 1),
(19, 'content19', 'answer19', 'SHORT_ANSWER', 3, 1),
(20, 'content20', 'answer20', 'SHORT_ANSWER', 3, 1),
(21, 'content21', 'answer21', 'SHORT_ANSWER', 3, 1),
(22, 'content22', 'answer22', 'SHORT_ANSWER', 3, 1),
(23, 'content23', 'answer23', 'SHORT_ANSWER', 3, 1),
(24, 'content24', 'answer24', 'SHORT_ANSWER', 3, 1),
(25, 'content25', 'answer25', 'SHORT_ANSWER', 3, 1),
(26, 'content26', 'answer26', 'ESSAY', 3, 1),
(27, 'content27', 'answer27', 'ESSAY', 3, 1),
(28, 'content28', 'answer28', 'ESSAY', 3, 1),
(29, 'content29', 'answer29', 'ESSAY', 3, 1),
(30, 'content30', 'answer30', 'ESSAY', 3, 1),
(31, 'content31', 'answer31', 'ESSAY', 3, 1),
(32, 'content32', 'answer32', 'ESSAY', 3, 1),
(33, 'content33', 'answer33', 'ESSAY', 3, 1),
(34, 'content34', 'answer34', 'ESSAY', 3, 1),
(35, 'content35', 'answer35', 'ESSAY', 3, 1);

-- grade:3, chapter:2 problem
INSERT INTO problem (id, content, answer, problem_type, grade, chapter) VALUES
(36, 'content36', 'answer36', 'MULTIPLE_CHOICE', 3, 2),
(37, 'content37', 'answer37', 'MULTIPLE_CHOICE', 3, 2),
(38, 'content38', 'answer38', 'MULTIPLE_CHOICE', 3, 2),
(39, 'content39', 'answer39', 'MULTIPLE_CHOICE', 3, 2),
(40, 'content40', 'answer40', 'MULTIPLE_CHOICE', 3, 2),
(41, 'content41', 'answer41', 'MULTIPLE_CHOICE', 3, 2),
(42, 'content42', 'answer42', 'MULTIPLE_CHOICE', 3, 2),
(43, 'content43', 'answer43', 'MULTIPLE_CHOICE', 3, 2),
(44, 'content44', 'answer44', 'MULTIPLE_CHOICE', 3, 2),
(45, 'content45', 'answer45', 'MULTIPLE_CHOICE', 3, 2),
(46, 'content46', 'answer46', 'MULTIPLE_CHOICE', 3, 2),
(47, 'content47', 'answer47', 'MULTIPLE_CHOICE', 3, 2),
(48, 'content48', 'answer48', 'MULTIPLE_CHOICE', 3, 2),
(49, 'content49', 'answer49', 'MULTIPLE_CHOICE', 3, 2),
(50, 'content50', 'answer50', 'MULTIPLE_CHOICE', 3, 2),
(51, 'content51', 'answer51', 'SHORT_ANSWER', 3, 2),
(52, 'content52', 'answer52', 'SHORT_ANSWER', 3, 2),
(53, 'content53', 'answer53', 'SHORT_ANSWER', 3, 2),
(54, 'content54', 'answer54', 'SHORT_ANSWER', 3, 2),
(55, 'content55', 'answer55', 'SHORT_ANSWER', 3, 2),
(56, 'content56', 'answer56', 'SHORT_ANSWER', 3, 2),
(57, 'content57', 'answer57', 'SHORT_ANSWER', 3, 2),
(58, 'content58', 'answer58', 'SHORT_ANSWER', 3, 2),
(59, 'content59', 'answer59', 'SHORT_ANSWER', 3, 2),
(60, 'content60', 'answer60', 'SHORT_ANSWER', 3, 2),
(61, 'content61', 'answer61', 'ESSAY', 3, 2),
(62, 'content62', 'answer62', 'ESSAY', 3, 2),
(63, 'content63', 'answer63', 'ESSAY', 3, 2),
(64, 'content64', 'answer64', 'ESSAY', 3, 2),
(65, 'content65', 'answer65', 'ESSAY', 3, 2),
(66, 'content66', 'answer66', 'ESSAY', 3, 2),
(67, 'content67', 'answer67', 'ESSAY', 3, 2),
(68, 'content68', 'answer68', 'ESSAY', 3, 2),
(69, 'content69', 'answer69', 'ESSAY', 3, 2),
(70, 'content70', 'answer70', 'ESSAY', 3, 2);


-- Problem Set 1: Grade 3, Chapter 1
INSERT INTO problem_set_to_problem (problem_set_id, problem_id) VALUES
(1, 1), (1, 2), (1, 3), (1, 4), (1, 5),
(1, 6), (1, 7), (1, 8), (1, 9), (1, 10);

-- Problem Set 2: Grade 3, Chapter 2
INSERT INTO problem_set_to_problem (problem_set_id, problem_id) VALUES
(2, 36), (2, 37), (2, 38), (2, 39), (2, 40),
(2, 41), (2, 42), (2, 43), (2, 44), (2, 45);

-- 학생 90명 추가
-- ('조태윤', '010-2827-3729', 2, 2, 0),
-- ('임태윤', '010-4607-6305', 1, 8, 0),
-- ('김태윤', '010-1424-5542', 3, 6, 1),
-- ('윤건우', '010-8357-8476', 2, 7, 0),
-- ('최진우', '010-2470-1652', 3, 5, 0),
-- ('장지훈', '010-6441-6559', 3, 9, 0),
-- ('장민수', '010-5481-4277', 3, 4, 1),
-- ('윤지훈', '010-8562-6016', 2, 9, 0),
-- ('정건우', '010-4738-3455', 1, 5, 1),
-- ('박수빈', '010-7283-5065', 2, 4, 1),
-- ('조예준', '010-6290-5568', 2, 2, 0),
-- ('장하윤', '010-3952-2304', 1, 4, 1),
-- ('최진우', '010-1296-5697', 2, 10, 0),
-- ('장태윤', '010-9255-1743', 3, 3, 1),
-- ('윤하윤', '010-4964-3787', 3, 7, 1),
-- ('장도윤', '010-2981-6871', 2, 6, 0),
-- ('강하윤', '010-4959-7024', 2, 10, 0),
-- ('최민수', '010-2552-1940', 1, 5, 1),
-- ('이건우', '010-4311-4059', 3, 6, 1),
-- ('임서연', '010-4633-8869', 3, 10, 0),
-- ('장태윤', '010-6157-2229', 3, 1, 1),
-- ('강건우', '010-4102-9753', 1, 10, 1),
-- ('강도윤', '010-8985-8320', 1, 8, 1),
-- ('김태윤', '010-7575-3544', 1, 2, 1),
-- ('최태윤', '010-8544-4597', 3, 1, 0),
-- ('윤진우', '010-6944-2605', 3, 5, 1),
-- ('장진우', '010-6733-7926', 1, 9, 1),
-- ('조예준', '010-6456-8699', 3, 1, 1),
-- ('강지훈', '010-7771-9047', 1, 1, 0),
-- ('윤진우', '010-7577-9551', 3, 8, 1),
-- ('임하윤', '010-3531-9448', 2, 9, 0),
-- ('윤건우', '010-7870-4955', 2, 8, 1),
-- ('장진우', '010-9357-9151', 3, 4, 0),
-- ('최건우', '010-6328-3695', 3, 10, 0),
-- ('강진우', '010-1781-5353', 2, 8, 1),
-- ('조도윤', '010-1021-6713', 3, 1, 0),
-- ('임수빈', '010-5528-9348', 2, 6, 0),
-- ('조하윤', '010-6113-3007', 3, 5, 0),
-- ('임서연', '010-6867-8614', 3, 8, 1),
-- ('김예준', '010-2293-8687', 1, 8, 1),
-- ('정서연', '010-2010-5752', 2, 9, 1),
-- ('정수빈', '010-3623-2265', 2, 10, 0),
-- ('장태윤', '010-8756-7832', 2, 4, 0),
-- ('강하윤', '010-3940-1146', 2, 10, 1),
-- ('장예준', '010-2713-9304', 3, 5, 1),
-- ('윤지훈', '010-7138-1613', 1, 8, 0),
-- ('임예준', '010-4991-8269', 3, 5, 1),
-- ('임도윤', '010-6961-9073', 1, 1, 1),
-- ('조도윤', '010-3539-5643', 3, 1, 1),
-- ('장서연', '010-7669-3141', 1, 5, 0),
-- ('윤하윤', '010-5316-8586', 3, 1, 0),
-- ('임진우', '010-7070-2457', 2, 8, 1),
-- ('임서연', '010-7288-6257', 3, 8, 0),
-- ('박건우', '010-2324-5322', 3, 2, 1),
-- ('최건우', '010-5939-1476', 3, 3, 0),
-- ('최진우', '010-5460-2512', 1, 6, 0),
-- ('임도윤', '010-8620-5580', 1, 6, 0),
-- ('정수빈', '010-4092-8629', 2, 3, 0),
-- ('윤지훈', '010-3416-5903', 1, 6, 0),
-- ('이태윤', '010-8687-2488', 2, 2, 1),
-- ('임도윤', '010-2716-5700', 1, 6, 1),
-- ('조건우', '010-8890-9678', 1, 5, 1),
-- ('임수빈', '010-1100-1429', 2, 10, 1),
-- ('박건우', '010-8466-6105', 1, 8, 1),
-- ('이예준', '010-9555-8820', 2, 7, 1),
-- ('이도윤', '010-4515-3862', 2, 8, 0),
-- ('박지훈', '010-5502-7804', 1, 5, 0),
-- ('정하윤', '010-6009-3183', 1, 9, 0),
-- ('조건우', '010-2848-4486', 1, 9, 1),
-- ('조하윤', '010-2533-5760', 1, 6, 1),
-- ('박태윤', '010-8322-5058', 2, 5, 0),
-- ('윤건우', '010-2569-7553', 2, 5, 1),
-- ('최예준', '010-9226-9629', 3, 8, 1),
-- ('윤건우', '010-2451-4087', 2, 3, 1),
-- ('이지훈', '010-5340-8107', 3, 4, 0),
-- ('박태윤', '010-8988-1851', 1, 1, 0),
-- ('박진우', '010-5005-4173', 1, 7, 0),
-- ('박예준', '010-5272-9643', 1, 3, 1),
-- ('윤진우', '010-5253-7900', 2, 7, 1),
-- ('임하윤', '010-8176-6419', 1, 3, 0),
-- ('강태윤', '010-2057-9825', 3, 8, 1),
-- ('조건우', '010-1772-8412', 2, 10, 1),
-- ('최하윤', '010-4739-1478', 1, 9, 1),
-- ('박건우', '010-4724-5487', 1, 5, 0),
-- ('최태윤', '010-2217-2303', 3, 2, 1),
-- ('장서연', '010-4802-3197', 3, 4, 0),
-- ('최하윤', '010-5480-2000', 2, 9, 0),
-- ('윤지훈', '010-5208-2723', 1, 3, 0),
-- ('윤태윤', '010-6413-6405', 1, 4, 0),
-- ('조하윤', '010-7564-9587', 2, 4, 1),
-- ('임지훈', '010-2018-6442', 3, 5, 1);
