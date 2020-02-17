## VIEW

SELECT 쿼리의 실행 결과를 화면에 저장한 **논리적 가상 테이블**입니다.

실제 테이블과는 다르게 실질적 데이터를 저장하고 있진 않지만 사용자는 테이블을 사용하는 것과 동일하게 사용 가능합니다.

### 표현식
* CREATE [OR REPLACE] VIEW 뷰이름 AS 서브쿼리
* OR REPLACE : 뷰 생성 시 같은 이름의 뷰가 기존에 존재한다면 해당 뷰를 새롭게 변경
* OR REPLACE를 사용하지 않고 뷰를 생성 후 같은 이름의 뷰 또 생성 시 이미 다른 객체가 사용중인 이름이라고 에러 발생

* 베이스테이블의 정보가 변경되면 VIEW도 변경됨

* 생성된 뷰 컬럼에 별칭 부여
* 서브쿼리의 SELECT절에 함수가 사용된 경우 반드시 별칭 지정(뷰 서브쿼리 안에 연산 결과도 포함 가능)

* 생성된 뷰를 이용해 DML문 사용 가능
* 뷰에서 요청한 DML구문은 베이스 테이블도 변경함

### DML 명령어로 VIEW 조작이 불가능한 경우

1. 뷰 정의에 포함되지 않은 컬럼을 조작하는 경우

```MYSQL
CREATE OR REPLACE VIEW V_JOB2
AS SELECT JOB_CODE
    FROM JOB;
    
INSERT INTO V_JOB2 VALUES('J8', '인턴');
-- ORA-00913: too many values

UPDATE V_JOB2
SET JOB_NAME = '인턴'
WHERE JOB_CODE = 'J7';
-- ORA-00904: "JOB_NAME": invalid identifier

DELETE FROM V_JOB2
WHERE JOB_NAME = '사원';
-- ORA-00904: "JOB_NAME": invalid identifier
```

2. 뷰에 포함되지 않은 컬럼 중에 베이스가 되는 컬럼이<br>
    NOT NULL 제약조건이 지정된 경우
    (INSERT에서만 오류 발생)

```MYSQL
CREATE OR REPLACE VIEW V_JOB3
AS SELECT JOB_NAME
    FROM JOB;
    
INSERT INTO V_JOB3 VALUES ('인턴');
-- ORA-01400: cannot insert NULL into ("KH"."JOB"."JOB_CODE")
-- JOB_CODE가 NOT NULL 제약조건인데 JOB_CODE 없이 JOB_NAME만 집어 넣어서 JOB_CODE가 NULL이 되기 때문에

INSERT INTO JOB VALUES('J8', '인턴');

UPDATE V_JOB3			-- 가능
SET JOB_NAME = '알바'
WHERE JOB_NAME = '인턴';

DELETE FROM V_JOB3		-- 가능
WHERE JOB_NAME ='알바';
```

3. 산술 표현식으로 정의된 경우

```MYSQL
CREATE OR REPLACE VIEW EMP_SAL
AS SELECT EMP_ID, EMP_NAME, SALARY, (SALARY + (SALARY*NVL(BONUS,0))) *12 연봉
    FROM EMPLOYEE;

INSERT INTO EMP_SAL VALUES(800, '정진훈', 3000000, 36000000);
-- ORA-01733: virtual column not allowed here
-- 맨 뒤 보너스 포함 연봉이 산술 표현식으로 정의되어있기 때문에 불가능

UPDATE EMP_SAL
SET 연봉 = 8000000
WHERE EMP_ID = 200;
-- ORA-01733: virtual column not allowed here

DELETE FROM EMP_SAL		-- 가능
WHERE 연봉 = 124800000;
```

4. 그룹함수나 GROUP BY절을 포함한 경우

```MYSQL
CREATE OR REPLACE VIEW V_GROUPDEPT
AS SELECT DEPT_CODE, SUM(SALARY) 합계, AVG(SALARY) 평균
    FROM EMPLOYEE
    GROUP BY DEPT_CODE;

INSERT INTO V_GROUPDEPT
VALUES('D10', 6000000, 4000000);
-- ORA-01733: virtual column not allowed here

UPDATE V_GROUPDEPT
SET DEPT_CODE = 'D10'
WHERE DEPT_CODE = 'D1';
-- ORA-01732: data manipulation operation not legal on this view

DELETE FROM V_GROUPDEPT
WHERE DEPT_CODE = 'D1';
-- ORA-01732: data manipulation operation not legal on this view
```

5. DISTINCT를 포함한 경우

```MYSQL
CREATE OR REPLACE VIEW V_DT_EMP
AS SELECT DISTINCT JOB_CODE
    FROM EMPLOYEE;

INSERT INTO V_DT_EMP VALUES ('J9');
-- ORA-01732: data manipulation operation not legal on this view

UPDATE V_DT_EMP
SET JOB_CODE = 'J9'
WHERE JOB_CODE = 'J7';
-- ORA-01732: data manipulation operation not legal on this view

DELETE FROM V_DT_EMP
WHERE JOB_CODE = 'J1';
-- ORA-01732: data manipulation operation not legal on this view
```

6. JOIN을 이용해 여러 테이블을 연결한 경우

```MYSQL
CREATE OR REPLACE VIEW V_JOINEMP
AS SELECT EMP_ID, EMP_NAME, DEPT_TITLE
    FROM EMPLOYEE
        JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID);

INSERT INTO V_JOINEMP VALUES(888, '조세오', '인사관리부');
-- ORA-01776: cannot modify more than one base table through a join view

UPDATE V_JOINEMP
SET DEPT_TITLE = '인사관리부'
WHERE EMP_ID = 219;
-- ORA-01779: cannot modify a column which maps to a non key-preserved table

DELETE FROM V_JOINEMP
WHERE EMP_ID = 210;
```

### VIEW 옵션

1. OR REPLACE 옵션
	기존에 동일한 뷰 이름이 존재하느 경우 덮어쓰고, 존재하지 않으면 새로 생성

2. FORCE/NOFORCE 옵션
	FORCE옵션은 서브쿼리에 사용된 테이블이 존재하지 않아도 뷰 생성
	NOFORCE 옵션은 서브쿼리에 사용된 테이블이 존재해야만 뷰 생성(기본 값)

```MYSQL
CREATE OR REPLACE /*NOFORCE*/ VIEW V_EMP2
AS SELECT TCODE, TNAME, TCONTENT
    FROM TT;
-- ORA-00942: table or view does not exist

CREATE OR REPLACE FORCE VIEW V_EMP2
AS SELECT TCODE, TNAME, TCONTENT
    FROM TT;
-- 경고: 컴파일 오류와 함께 뷰가 생성되었습니다.
```

3. WITH CHECK OPTION 옵션
	옵션을 설정한 컬럼의 값을 수정 불가능하게 함

```MYSQL
CREATE OR REPLACE VIEW V_EMP3
AS SELECT * 
   FROM EMPLOYEE
   WHERE DEPT_CODE = 'D9' WITH CHECK OPTION;

UPDATE V_EMP3
SET DEPT_CODE = 'D1'
WHERE EMP_ID = 200;
-- ORA-01402: view WITH CHECK OPTION where-clause violation
```

4. WITH READ ONLY 옵션
	뷰에 대해 조회만 가능하고 삽입, 수정, 삭제 등은 불가능하게 함

```MYSQL
CREATE OR REPLACE VIEW V_DEPT
AS SELECT * FROM DEPARTMENT
WITH READ ONLY;

DELETE FROM V_DEPT;
-- ORA-42399: cannot perform a DML operation on a read-only view
```




