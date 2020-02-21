## PL/SQL

Procedural Language extension to SQL의 약자로 **오라클 자체에 내장되어 있는 절차적 언어**입니다.

SQL의 단점을 보완하여 SQL문장 내에서 변수의 정의, 조건 처리(IF), 반복 처리(LOOP, FOR, WHILE) 등 지원합니다.

### PL/SQL 구조

|구조|설명|
|:---:|:---:|
|DECLARE SECTION<br>(선언부)|DECLARE로 시작<br>변수나 상수를 선언하는 부분|
|EXECUTABLE SECTION<br>(실행부)|BEGIN으로 시작<br>제어문, 반복문, 함수 정의 등 로직 기술|
|EXCEPTION SECTION<br>(예외처리부)|EXCEPTION으로 시작<br>예외사항 발생 시 해결하기 위한 문장 기술|

```
PL/SQL 구조
     선언부 : DECLARE로 시작
         변수, 상수 선언
     실행부 : BEGIN으로 시작
         로직 기술
     예외처리부 : EXCEPTION
         예외 상황 발생 시 해결하기 위한 문장 기술
```

* 프로시저를 사용하여 출력하는 내용을 화면에 보여주도록 설정하는 환경변수로 기본 값은 OFF여서 ON으로 변경

EX) SET SERVEROUTPUT ON;

### 타입 변수 선언

```MYSQL
-- 타입 변수 선언
-- 변수의 선언 및 초기화, 변수 값 출력
DECLARE -- 선언부
    EMP_ID NUMBER;              -- NUMBER타입 변수 EMP_ID 선언     ==> JAVA : int empId;
    EMP_NAME VARCHAR2(30);      -- VARCHAR2타입 변수 EMP_NAME 선언 ==> JAVA : String empName;
    
    PI CONSTANT NUMBER := 3.14; -- NUMBER타입 상수 PI 선언         ==> JAVA : final double PI = 3.14;
    -- 변수 값 대입 연산자 :=
BEGIN -- 실행부
    EMP_ID := 888;          -- EMP_ID변수에 888로 값 초기화
    EMP_NAME := '홍길동';    -- EMP_NAME변수에 배장남으로 값 초기화
    
    DBMS_OUTPUT.PUT_LINE('EMP_ID : ' || EMP_ID);
    DBMS_OUTPUT.PUT_LINE('EMP_NAME : ' || EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('PI : ' || PI);

-- PUT_LINE이라는 프로시저를 이용하여 출력(DBMS_OTUPUT패키지에 속해있음)

END;
/
```

### 레퍼런스 변수의 선언

```MYSQL
DECLARE
    EMP_ID EMPLOYEE.EMP_ID%TYPE; -- 변수 EMP_ID의 타입을 EMPLOYEE테이블의 EMP_ID컬럼 타입으로 지정
    EMP_NAME EMPLOYEE.EMP_NAME%TYPE;
BEGIN
    SELECT EMP_ID, EMP_NAME -- 컬럼 이름
    INTO EMP_ID, EMP_NAME   -- 변수 이름
    FROM EMPLOYEE
    WHERE EMP_ID = '&EMP_ID';   -- &는 대체변수를 받으라는 명령어, 뒤에 값은 안내문에 출력될 문구를 말함
        
    DBMS_OUTPUT.PUT_LINE('EMP_ID : ' || EMP_ID);
    DBMS_OUTPUT.PUT_LINE('EMP_NAME : ' || EMP_NAME);
END;
/
```

* 한 행에 대한 ROWTYPE변수 선언과 초기화

```MYSQL
DECLARE
    E EMPLOYEE%ROWTYPE;
    -- %ROWTYPE : 테이블 또는 뷰의 컬럼 데이터 형, 크기, 속성 참조
BEGIN
    SELECT *
    INTO E
    FROM EMPLOYEE
    WHERE EMP_ID = '&사번';
    
    DBMS_OUTPUT.PUT_LINE('EMP_ID : ' || E.EMP_ID);
    DBMS_OUTPUT.PUT_LINE('EMP_NAME : ' || E.EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('EMP_NO : ' || E.EMP_NO);
    DBMS_OUTPUT.PUT_LINE('SALARY : ' || E.SALARY);
END;
/
```

### 선택문(조건문)
* IF ~ THEN ~ END IF (단일 IF문)
* IF ~ THEN ~ ELSE ~ END IF (IF ~ ELSE문)
* IF ~ THEN ~ ELSIF ~ ELSE ~ END IF (IF ~ ELSE IF ~ ELSE문)

```MYSQL
DECLARE
    GRADE VARCHAR2(10);
    SCORE INT; -- NUMBER(30)과 같은 타입
BEGIN
    SCORE := '&점수입력';
    
    IF SCORE >= 90 THEN GRADE:= 'A';
    ELSIF SCORE >= 80 THEN GRADE:= 'B';
    ELSIF SCORE >= 70 THEN GRADE:= 'C';
    ELSIF SCORE >= 60 THEN GRADE:= 'D';
    ELSE GRADE := 'F';
    END IF;
    
    DBMS_OUTPUT.PUT_LINE('당신의 점수는 ' || SCORE || '점이고, 학점은 ' || GRADE ||'학점입니다.');   
END;
/
```

* CASE ~ WHEN ~ THEN ~ END (SWITCH ~ CASE문)

```MYSQL
DECLARE
    EMP EMPLOYEE%ROWTYPE;
    DNAME VARCHAR2(20);
BEGIN
    SELECT *
    INTO EMP
    FROM EMPLOYEE
    WHERE EMP_ID = '&사번';
    
    DNAME := CASE EMP.DEPT_CODE
                WHEN 'D1' THEN '인사관리부'
                WHEN 'D2' THEN '회계관리부'
                WHEN 'D3' THEN '마케팅부'
                WHEN 'D4' THEN '국내영업부'
                WHEN 'D5' THEN '해외영업1부'
                WHEN 'D6' THEN '해외영업2부'
                WHEN 'D7' THEN '해외영업3부'
                WHEN 'D8' THEN '기술지원부'
                WHEN 'D9' THEN '총무부'
              END;
    
    DBMS_OUTPUT.PUT_LINE('사번    이름       부서명');
    DBMS_OUTPUT.PUT_LINE(EMP.EMP_ID || '    ' || EMP.EMP_NAME || '      ' || DNAME);
END;
/
```

### 반복문

#### BASIC LOOP

```
LOOP
       처리문
       조건문
   END LOOP;
   
   조건문
       1) IF 조건식 THEN EXIT; END IF;
       2) EXIT WHEN 조건식;
```

```MYSQL
-- 1 ~ 5까지 순차적으로 출력
DECLARE
    N NUMBER := 1;
BEGIN
    LOOP
        DBMS_OUTPUT.PUT_LINE(N);
        N := N+1;
        
--        IF N > 5 THEN EXIT;
--        END IF;
        EXIT WHEN N > 5;    -- IF 조건식 THEN EXIT; END IF; 보다 더 많이 쓰임
    END LOOP;
END;
/
```

#### FOR LOOP

```
   FOR 인덱스 IN [REVERSE] 초기값..최종값
   LOOP
       처리문
   END LOOP;
```

```MYSQL
-- 1 ~ 5까지 순서대로 출력
BEGIN
    FOR N IN 1..5
    LOOP
        DBMS_OUTPUT.PUT_LINE(N);
    END LOOP;
END;
/
```

#### WHILE LOOP

```
   WHILE 조건
   LOOP
       처리문
   END LOOP;
```

```MYSQL
-- 1 ~ 5출력
DECLARE
    N NUMBER := 1;
BEGIN
    WHILE N <= 5
    LOOP
        DBMS_OUTPUT.PUT_LINE(N);
        N := N +1;
    END LOOP;
END;
/
```

### 테이블 타입
* 테이블 : 키와 값의 쌍으로 이루어진 컬렉션
* 하나의 테이블의 한 개의 컬럼 데이터 저장

```
    TYPE 테이블명 IS TABLE OF 데이터타입
    INDEX BY BINARY_INTEGER;
```

```MYSQL
DECLARE
    -- 테이블 타입 선언
    TYPE EMP_ID_TABLE_TYPE IS TABLE OF EMPLOYEE.EMP_ID%TYPE
    INDEX BY BINARY_INTEGER;
    -- EMPLOYEE.EMP_ID타입의 데이터를 저장할 수 있는 테이블 타입 EMP_ID_TABLE_TYPE 선언
    
    TYPE EMP_NAME_TABLE_TYPE IS TABLE OF EMPLOYEE.EMP_NAME%TYPE
    INDEX BY BINARY_INTEGER;
    -- EMPLOYEE.EMP_NAME타입의 데이터를 저장할 수 있는 테이블 타입 EMP_NAME_TABLE_TYPE 선언
    
    -- 변수 선언
    -- 테이블 타입 EMP_ID_TABLE_TYPE 변수 EMP_ID_TABLE 선언
    EMP_ID_TABLE EMP_ID_TABLE_TYPE;
    
    -- 테이블 타입 EMP_NAME_TABLE_TYPE 변수 EMP_NAME_TABLE 선언
    EMP_NAME_TABLE EMP_NAME_TABLE_TYPE;
    
    I BINARY_INTEGER := 0;
BEGIN
    FOR K IN(SELECT EMP_ID, EMP_NAME FROM EMPLOYEE)
    -- K에 SELECT해온 행 하나하나가 들어감
    LOOP
        I := I+1;
        
        EMP_ID_TABLE(I) := K.EMP_ID;
        EMP_NAME_TABLE(I) := K.EMP_NAME;
    END LOOP;
    
    FOR J IN 1..I
    LOOP
        DBMS_OUTPUT.PUT_LINE('EMP_ID : ' || EMP_ID_TABLE(J) || ', EMP_NAME : ' || EMP_NAME_TABLE(J));
    END LOOP;
END;
/
```

### 레코드 타입
* 서로 다른 유형의 데이터를 한 줄로 나열한 형태
* 테이블 타입의 경우 한 타입만 들어갈 수 있다면 레코드 타입의 경우 내가 정한 여러 타입이 들어갈 수 있음

```    
TYPE 레코드명 IS RECORD(
    필드명 필드타입 [[NOT NULL] := DEFAULT 값],
    필드명 필드타입 [[NOT NULL] := DEFAULT 값],
    ...
);
```

```MYSQL
DECLARE
    -- 레코드 타입 선언
    TYPE EMP_RECORD_TYPE IS RECORD(
        EMP_ID EMPLOYEE.EMP_ID%TYPE,
        EMP_NAME EMPLOYEE.EMP_NAME%TYPE,
        DEPT_TITLE DEPARTMENT.DEPT_TITLE%TYPE,
        JOB_NAME JOB.JOB_NAME%TYPE
    );
    
    EMP_RECORD EMP_RECORD_TYPE;
BEGIN
    SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME
    INTO EMP_RECORD
    FROM EMPLOYEE
        LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
        LEFT JOIN JOB USING(JOB_CODE)
    WHERE EMP_NAME = '&이름';
    
    DBMS_OUTPUT.PUT_LINE('사번 : ' || EMP_RECORD.EMP_ID);
    DBMS_OUTPUT.PUT_LINE('이름 : ' || EMP_RECORD.EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('부서 : ' || EMP_RECORD.DEPT_TITLE);
    DBMS_OUTPUT.PUT_LINE('직급 : ' || EMP_RECORD.JOB_NAME);
END;
/
```

### 예외 처리
* EXCEPTION절에 예외 상황 발생 시 해결하기 위한 문장 기술
* 미리 정의된 예외의 종류

```
NO_DATA_FOUND    : SELECT문이 아무런 데이터 행을 반환하지 못할 때
DUP_VAL_ON_INDEX : UNIQUE제약을 갖는 컬럼에 중복된 데이터가 들어갔을 때
ZERO_DIVIDE      : 0으로 나눌 때
등이 있음
```

```MYSQL
BEGIN
    UPDATE EMPLOYEE
    SET EMP_ID = '&사번'
    WHERE EMP_ID = 200;
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
    DBMS_OUTPUT.PUT_LINE('이미 존재하는 사번입니다.');
END;
/
```

```MYSQL
DECLARE
    NAME VARCHAR2(30);
BEGIN
    SELECT EMP_NAME
    INTO NAME
    FROM EMPLOYEE
    WHERE EMP_ID = 5;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
    DBMS_OUTPUT.PUT_LINE('조회 결과가 없습니다.');
END;
/
```


