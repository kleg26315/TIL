# DML (Date Manipulation Language)

데이터 조작 언어로 테이블에 값을 삽입(INSERT), 수정(UPDATE), 삭제(DELETE)하는 구문을 말합니다.

## INSERT 
* 모든 컬럼에 INSERT하고 싶은 경우 컬럼 명 생략 가능, 단, 컬럼의 순서를 지켜서 VALUES에 값 기입

```MYSQL
INSERT INTO EMPLOYEE (EMP_ID, EMP_NAME, EMP_NO, EMAIL, PHONE, DEPT_CODE,
		       JOB_CODE, SAL_LEVEL, SALARY, BONUS, MANAGER_ID,
		       HIRE_DATE, ENT_DATE, ENT_YN)
VALUES(900, '장채현', '901123-1080503', 'jang_ch@kh.or.kr', '01055569512', 'D1', 'J8',
	'S3', 4300000, 0.2, '200', SYSDATE, NULL, DEFAULT);
  
또는

INSERT INTO EMPLOYEE
VALUES(900, '장채현', '901123-1080503', 'jang_ch@kh.or.kr', '01055569512', 'D1', 'J8',
	'S3', 4300000, 0.2, '200', SYSDATE, NULL, DEFAULT);

```

* INSERT시 VALUES 대신 서브쿼리 이용 가능

```MYSQL
CREATE TABLE EMP_01(
	EMP_ID NUMBER,
	EMP_NAME VARCHAR2(30),
	DEPT_TITLE VARCHAR2(20)
);
INSERT INTO EMP_01(
	SELECT EMP_ID,
		EMP_NAME,
		DEPT_TITLE
	FROM EMPLOYEE
	LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
);
```

## INSERT ALL

INSERT 시 서브쿼리가 사용하는 테이블이 같은 경우 두 개 이상의 테이블에 INSERT ALL을 이용하여 한 번에 삽입 가능<br>
**단, 각 서브쿼리의 조건절이 같아야 함**

* INSERT ALL 예시

```MYSQL
CREATE TABLE EMP_DEPT_D1
AS SELECT EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE
    FROM EMPLOYEE
    WHERE 1 = 0;

// WHERE 절이 항상 false이기 때문에 컬럼 틀만 가져오고 안에 데이터는 가져오지 않음
```

* INSERT ALL 예시 2

```MYSQL
INSERT ALL
INTO EMP_DEPT_D1 VALUES(EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE)
INTO EMP_MANAGER VALUES(EMP_ID, EMP_NAME, MANAGER_ID)
SELECT EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE, MANAGER_ID
FROM EMPLOYEE
WHERE DEPT_CODE = ‘D1’;

INSERT ALL
WHEN HIRE_DATE < ‘2000/01/01’ THEN
INTO EMP_OLD VALUES(EMP_ID, EMP_NAME, HIRE_DATE, SALARY)
WHEN HIRE_DATE >= ‘2000/01/01’ THEN
INTO EMP_NEW VALUES(EMP_ID, EMP_NAME, HIRE_DATE, SALARY)
SELECT EMP_ID, EMP_NAME, HIRE_DATE, SALARY
FROM EMPLOYEE;
```

## UPDATE

테이블에 기록된 컬럼 값을 수정하는 구문으로 테이블 전체 행 개수는 변화가 없습니다.

* WHERE 조건을 설정하지 않으면 모든 행의 컬럼 값이 변경되니 주의해야 함

* UPDATE 예시

```MYSQL
UPDATE DEPT_COPY
SET DEPT_TITLE = ‘전략기획팀’
WHERE DEPT_ID = ‘D9’;
```

## DELETE

테이블의 행을 삭제하는 구문으로 테이블의 행 개수가 줄어듦

* WHERE 조건을 설정하지 않으면 모든 행이 삭제되니 주의해야 함
* FOREIGN KEY 제약조건이 설정되어 있는 경우 참조되고 있는 값에 대해서는 삭제 불가능
* 삭제 시 FOREGIN KEY 제약조건으로 컬럼 삭제가 불가능한 경우 제약조건을 비활성화 할 수 있음

* DELETE 예시

```MYSQL
DELETE FROM DEPARTMENT
WHERE DEPT_ID = ‘D1’;

ALTER TABLE EMPLOYEE
DISABLE CONSTRAINT EMP_DEPTCODE_FK CASCADE;

DELETE FROM DEPARTMENT
WHERE DEPT_ID = ‘D1’;

ALTER TABLE EMPLOYEE
ENABLE CONSTRAINT EMP_DEPTCODE_FK;
// 비활성화 된 제약 조건을 다시 활성화 시킬 수 있음
```

## TRUNCATE

* 테이블 전체 행 삭제 시 사용하며 DELETE보다 수행 속도가 빠르고 ROLLACK을 통해 복구 불가능
* DELETE와 마찬가지로 FOREIGN KEY 제약조건일 때는 적용 불가능하기 때문에 제약 조건을 비활성화 해야 삭제할 수 있음

* TRUNCATE 예시

```MYSQL
TRUNCATE TABLE EMP_SALARY;
SELECT * FROM EMP_SALARY;
// 모든 컬럼이 삭제되긴 하지만 테이블의 구조는 남아있음

ROLLBACK;
// ROLLBACK 후에도 컬럼이 복구되지 않음
```

