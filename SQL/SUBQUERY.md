## SUBQUERY (서브쿼리)

하나의 SQL문 안에 포함된 또 다른 SQL문으로 메인쿼리(기존쿼리)를 위해 보조 역할을 하는 쿼리문입니다.

서브쿼리와 비교할 항목은 반드시 서브쿼리의 SELECT한 항목의 개수와 자료형을 일치시켜야 합니다.

## 서브쿼리 유형

서브쿼리의 유형에 따라 서브쿼리 앞에 붙는 연산자가 달라집니다.

또한, 서브쿼리는 SELECT, WHERE, HAVING, FROM절에서도 사용 가능합니다.

### 단일 행 서브쿼리
* 서브쿼리의 조회 결과 값의 개수가 1개인 서브쿼리
* 일반적으로 단일 행 서브쿼리 앞에는 일반 연산자 사용
* <, >, <=, >=, =, !=, <>, ^=

### 다중행 서브쿼리
* 서브쿼리의 조회 결과 값의 행이 여러 개인 서브쿼리
* 다중행 서브쿼리 앞에는 일반 비교 연산자 사용 불가
* IN / NOT IN : 여러 개의 결과 값 중에서 한 개라도 일치하는 값이 있으면 / 없다면, 반환 값이 데이터 값
* \> ANY , < ANY : 여러 개의 결과 값 중에서 한 개라도 큰 / 작은 값이 있다면 (가장 작은 값보다 큰지 / 가장 큰 값보다 작은지)
* \> ALL , < ALL : 모든 값보다 큰 / 작은 값이 있다면 (가장 큰 값보다 큰지 / 가장 작은 값보다 작은지)
* EXISTS / NOT EXISTS : 값이 존재하는지 / 존재하지 않는지, 반환 값이 TRUE, FALSE

### 다중열 서브쿼리
* 서브쿼리의 조회 결과 컬럼의 개수가 여러 개인 서브쿼리

### 다중행 다중열 서브쿼리
* 서브쿼리의 조회 결과 컬럼의 개수와 행의 개수가 여러 개인 서브쿼리

```MYSQL
-- 인라인 뷰 (INLINE VIEW) : FROM절에서 서브쿼리 사용
-- 서브쿼리가 만든 결과(RESULT SET)를 테이블 대신 사용

-- 전 직원 중 급여가 높은 상위 5명의 순위, 이름, 급여 조회
SELECT ROWNUM, EMP_NAME, SALARY
FROM (SELECT *
      FROM EMPLOYEE
      ORDER BY SALARY DESC)
WHERE ROWNUM <= 5;
```

```MYSQL
-- WITH : 서브 쿼리에 이름을 붙여주고 사용 시 이름으로 사용하게 함
-- 인라인 뷰로 사용될 서브쿼리에 주로 사용
-- 같은 서브쿼리가 여러번 사용될 경우 중복 작성 줄임, 실행속도도 빨라짐
SELECT ROWNUM, EMP_NAME, SALARY
FROM (SELECT EMP_NAME, SALARY
      FROM EMPLOYEE
      ORDER BY SALARY DESC);

WITH TOPN_SAL AS (SELECT EMP_NAME, SALARY
                  FROM EMPLOYEE
                  ORDER BY SALARY DESC)
SELECT ROWNUM, EMP_NAME, SALARY
FROM TOPN_SAL;
```

```MYSQL
-- RANK() OVER / DENSE_RNAK() OVER
-- RANK() OVER : 동일한 순위 이후의 등수를 동일한 인원 수만큼 건너 뛰고 순위
SELECT RANK() OVER(ORDER BY SALARY DESC) 순위, EMP_NAME, SALARY
FROM EMPLOYEE;

-- DENSE_RANK() OVER : 중복되는 순위 이후의 등수를 바로 다음 등수로 처리
SELECT DENSE_RANK() OVER(ORDER BY SALARY DESC) 순위, EMP_NAME, SALARY
FROM EMPLOYEE;
```

### 상(호연)관 서브쿼리
* 서브쿼리가 만든 결과 값을 메인 쿼리가 비교 연산할 때 메인 쿼리
* 테이블의 값이 변경되면 서브쿼리의 결과 값도 바뀌는 서브쿼리

### 스칼라 서브쿼리
* 상관쿼리이면서 결과 값이 한 개인 서브쿼리
