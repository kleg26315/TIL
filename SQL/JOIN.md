## JOIN

하나 이상의 테이블에서 데이터를 조회하기 위해 사용하고 수행결과는 하나의 Result Set으로 나옵니다.

JOIN은 오라클 구문과 ANSI 표준 구문으로 나누어져 있습니다.

### 오라클 전용 구문

FROM절에 ','로 구분하여 합치게 될 테이블 명을 기술하고 WHERE절에 합치기에 사용할 컬럼 명을 명시합니다.

```MYSQL
SELECT EMP_ID, EMP_NAME, DEPT_CODE, DEPT_TITLE
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID;

// 연결에 사용할 두 컬럼 명이 다른 경우 그 자체로 사용 가능

SELECT EMP_ID, EMP_NAME, E.JOB_CODE, JOB_NAME
FROM EMPLOYEE E, JOB J
WHERE E.JOB_CODE = J.JOB_CODE;

// 연결에 사용할 두 컬럼 명이 같은 경우 테이블명.컬럼명으로 작성하여 구분
// FROM절에 사용한 테이블 별칭 이용 가능
```

### ANSI 표준 구문

연결에 사용하려는 컬럼 명이 같은 경우 USING() 사용, 다른 경우 ON() 사용합니다.

```MYSQL
SELECT EMP_ID, EMP_NAME, JOB_CODE, JOB_NAME, DEPT_NAME, NATIONAL_NAME
FROM EMPLOYEE
    JOIN JOB USING(JOB_CODE)
    JOIN DEPARTMENT ON (DEPT_ID = DEPT_CODE)
WHERE JOB_CODE ='J1';
```

## 내부조인 (INNER JOIN)
기본적으로 JOIN은 INNER JOIN이며<br>
두 개 이상의 테이블을 조인할 때 일치하는 값이 없는 행은 조인에서 제외됩니다.

OUTER JOIN은 일치하지 않은 값도 포함이 되며 반드시 OUTER JOIN 명시합니다.

## 외부조인 (OUTER JOIN)

두 테이블의 지정하는 컬럼 값이 일치 하지 않는 행도 조인에 포함합니다.

### LEFT [OUTER] JOIN
* 왼쪽에 기술된 테이블의 컬럼 수를 기준으로 JOIN할 때

```MYSQL
-- ANSI
SELECT EMP_NAME, DEPT_TITLE
FROM EMPLOYEE
    LEFT /*OUTER*/ JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);

-- ORACLE
SELECT EMP_NAME, DEPT_TITLE
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID(+); -- '내가 너한테 맞춰줄게 ~'라고 말하는 쪽이 (+)를 붙임
```

### RIGHT [OUTER] JOIN
* 오른쪽에 기술된 테이블의 컬럼 수를 기준으로 JOIN할 때

### FULL [OUTER] JOIN
* 합치기에 사용한 두 테이블이 가진 모든 행을 결과에 포함시킬 때
* 오라클에서는 FULL 조인이 불가능

```MYSQL
-- ANSI
SELECT EMP_NAME, DEPT_TITLE
FROM EMPLOYEE
    FULL JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID);

-- ORACLE
SELECT EMP_NAME, DEPT_TITLE
FROM EMPLOYEE, DEPARTMENT 
WHERE DEPT_CODE(+) = DEPT_ID(+); -- ORACLE에는 풀 조인이 불가능함
```

### CROSS JOIN
* 카테시안 곱(Cartesian Product)라고도 함
* 조인되는 테이블의 각 행들이 모두 매핑된 데이터가 검색되는 조인 방법
* 검색되는 데이터 수는 '행의 컬럼 수 * 또 다른 행의 컬럼 수'로 나옴

### 비등가 조인 (NON EQUAL JOIN)
* 지정한 컬럼 값이 일치하는 경우가 아닌 값의 범위에 포함되는 행들을 연결하는 방식

### 셀프조인 (자체조인)
* 두 개 이상의 서로 다른 테이블을 연결하는 것이 아닌 같은 테이블을 조인하는 것

### 다중 조인
* 하나 이상의 테이블에서 데이터를 조회하기 위해 사용하고 수행 결과는 하나의 Result Set으로 나옴
* 다중 조인의 경우 조인 순서가 매우 중요
