-- EMPLOYEE 테이블에서 사원의 이름, 입사일, 입사 후 6개월이 된 날짜 조회
SELECT EMP_NAME, HIRE_DATE, ADD_MONTHS(HIRE_DATE, 6)
FROM EMPLOYEE;

-- EMPLOYEE 테이블에서 사원명, 입사일-오늘, 오늘-입사일 조회
-- 단, 별칭은 근무일수1, 근무일수2로 하고
-- 모두 정수처리(내림), 양수가 되도록 처리
SELECT EMP_NAME, FLOOR(HIRE_DATE - SYSDATE) 근무일수1, FLOOR(SYSDATE - HIRE_DATE) 근무일수2
FROM EMPLOYEE;

-- EMPLOYEE 테이블에서 사번이 홀수인 직원들의 정보 모두 조회
SELECT *
FROM EMPLOYEE
WHERE MOD(EMP_ID, 2) = 1;

-- EMPLOYEE 테이블에서 근무 년수가 20년 이상인 직원 정보 조회
SELECT *
FROM EMPLOYEE
WHERE MONTHS_BETWEEN(SYSDATE, HIRE_DATE) / 12 >= 20;

-- EMPLOYEE 테이블에서 사원명, 입사일, 입사한 월의 근무일수를 조회
SELECT EMP_NAME, HIRE_DATE, LAST_DAY(HIRE_DATE) - HIRE_DATE + 1
FROM EMPLOYEE;

-- EMPLOYEE 테이블에서 사원의 이름, 입사일, 근무년수 조회
-- 단 근무년수는 (현재년도 - 입사년도)로 조회하세요
-- 1) EXTRACT
SELECT EMP_NAME, HIRE_DATE, EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE)
FROM EMPLOYEE;

-- 2) MONTHS_BETWEEN
SELECT EMP_NAME, HIRE_DATE, ROUND(MONTHS_BETWEEN(SYSDATE, HIRE_DATE) / 12)
FROM EMPLOYEE;

-- EMPLOYEE 테이블에서 사원명, 급여 조회
-- 급여는 '\9,000,000' 형식으로 표시
SELECT EMP_NAME, CONCAT('\', TO_CHAR(SALARY, 'FM9,999,999'))
FROM EMPLOYEE;

-- EMPLOYEE 테이블에서 이름, 입사일 조회
-- 입사일은 포맷 적용함 '2017년 12월 06일 (수)' 형식으로 출력
SELECT EMP_NAME, TO_CHAR(HIRE_DATE, 'YYYY"년" MM"월" DD"일" "("DY")')
FROM EMPLOYEE;

-- 직원의 급여를 인상하고자 한다
-- 직급코드가 J7인 직원은 급여의 10%를 인상하고
-- 직급코드가 J6인 직원은 급여의 15%를 인상하고
-- 직급코드가 J5인 직원은 급여의 20%를 인상하며
-- 그 외 직급의 직원은 급여의 5%만 인상한다.
-- 직원 테이블에서 직원명, 직급코드, 급여, 인상급여(위 조건)을 조회하세요
-- 1) DECODE
SELECT EMP_NAME, JOB_CODE, SALARY, DECODE(JOB_CODE, 'J7', SALARY*110, 'J6', SALARY*115, 'J5', SALARY*120, SALARY*105) 인상급여
FROM EMPLOYEE;

-- 2) CASE WHEN
SELECT EMP_NAME, JOB_CODE, SALARY, CASE WHEN JOB_CODE = 'J7' THEN SALARY*110
                                        WHEN JOB_CODE = 'J6' THEN SALARY*115
                                        WHEN JOB_CODE = 'J5' THEN SALARY*120
                                        ELSE SALARY*105 END 인상급여
FROM EMPLOYEE;

-- 사번, 사원명, 급여
-- 급여가 500만원 이상이면 '고급'
-- 급여가 300~500만원이면 '중급'
-- 그 이하는 '초급'으로 출력처리하고 별칭은 '구분'으로 한다.
SELECT EMP_ID, EMP_NAME, CASE WHEN SALARY>=5000000 THEN '고급'
                              WHEN SALARY>=3000000 AND SALARY<5000000 THEN '중급'
                              WHEN SALARY<30000000 THEN '초급' END 구분
FROM EMPLOYEE;

-- EMPLOYEE테이블에서 부서코드가 D5인 직원의 보너스 포함 연봉 조회
SELECT SALARY*12 + (1+ NVL(BONUS, 0))*SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5';


-- 직원명, 직급코드, 보너스가 포함된 연봉(원) 조회
--  단, 연봉은 ￦57,000,000 으로 표시되게 함
SELECT EMP_NAME, JOB_CODE, TO_CHAR(SALARY*12 + (1+ NVL(BONUS, 0))*SALARY, 'L99,999,9999')
FROM EMPLOYEE;

-- 부서코드가 D5, D9인 직원들 중에서 2004년도에 입사한 직원의 사번, 사원명, 부서코드, 입사일
SELECT EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE
FROM EMPLOYEE
WHERE (DEPT_CODE = 'D9' OR DEPT_CODE = 'D5') AND (TO_CHAR(HIRE_DATE, 'YYYY') = '2004');

-- 직원명, 입사일, 입사한 달의 근무일수 조회(단, 주말과 입사한 날도 근무일수에 포함함)
SELECT EMP_NAME, HIRE_DATE, LAST_DAY(HIRE_DATE) - HIRE_DATE + 1
FROM EMPLOYEE;

-- 부서코드가 D5와 D6이 아닌 사원들의 직원명, 부서코드, 생년월일, 나이(만) 조회
--  단, 생년월일은 주민번호에서 추출해서 ㅇㅇ년 ㅇㅇ월 ㅇㅇ일로 출력되게 하고
--  나이는 주민번호에서 추출해서 날짜데이터로 변환한 다음 계산
SELECT EMP_NAME, DEPT_CODE,/* TO_CHAR(TO_DATE(SUBSTR(EMP_NO, 1, 6), 'YYMMDD'), 'YY"년" MM"월" DD"일"') 생년월일,*/
                    SUBSTR(EMP_NO,1,2) ||'년'||SUBSTR(EMP_NO,3,2)||'월'||SUBSTR(EMP_NO,5,2)||'일' 생년월일,
                  (TO_CHAR(SYSDATE, 'YY') + 100 - TO_CHAR(TO_DATE(SUBSTR(EMP_NO, 1, 2), 'YY'), 'YY')) +1 나이
FROM EMPLOYEE;
    
-- 직원들의 입사일로 부터 년도만 가지고, 각 년도별 입사인원수를 구하시오.
--  아래의 년도에 입사한 인원수를 조회하시오.
--  => to_char, decode, sum 사용
--
--	-------------------------------------------------------------
--	전체직원수   2001년   2002년   2003년   2004년
--	-------------------------------------------------------------
SELECT '전체직원수', SUM(DECODE(TO_CHAR(HIRE_DATE, 'YY'), '01', 1, 0)) "2001년",
                    SUM(DECODE(TO_CHAR(HIRE_DATE, 'YY'), '01', 1, 0)) "2002년",
                    SUM(DECODE(TO_CHAR(HIRE_DATE, 'YY'), '01', 1, 0)) "2003년",
                    SUM(DECODE(TO_CHAR(HIRE_DATE, 'YY'), '01', 1, 0)) "2004년"
FROM EMPLOYEE;

--  부서코드가 D5이면 총무부, D6이면 기획부, D9이면 영업부로 처리하시오.
--   단, 부서코드가 D5, D6, D9 인 직원의 정보만 조회함
-- 1) DECODE
SELECT EMP_NAME, DECODE(DEPT_CODE, 'D5', '총무부', 'D6','기획부','D7','영업부')
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5' OR DEPT_CODE = 'D6' OR DEPT_CODE ='D7';

-- 2) CASE WHEN
SELECT EMP_NAME, CASE WHEN DEPT_CODE ='D5' THEN '총무부'
                      WHEN DEPT_CODE ='D6' THEN '기획부'
                      WHEN DEPT_CODE='D7' THEN '영업부' END
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5' OR DEPT_CODE = 'D6' OR DEPT_CODE ='D7';