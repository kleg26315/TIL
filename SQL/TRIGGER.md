## TRIGGER

테이블이나 뷰가 INSERT, UPDATE, DELETE 등의 **DML문에 의해** 변경될 경우 자동으로 실행될 내용을 정의하여 저장하는 객체입니다.

### 트리거 종류

* SQL문의 실행 시기에 따른 분류

BEFORE TRIGGER : SQL문 실행 전 트리거 실행
AFTER TRIGGER : SQL문 실행 후 트리거 실행

* SQL문에 의해 영향을 받는 각 ROW에 따른 분류

ROW TRIGGER : SQL문 각 ROW에 대해 한 번씩만 실행(FOR EACH ROW 옵션 작성)

STATEMENT TRIGGER : SQL문에 대해 한 번만 실행(DEFAULT)

EX) UPDATE EMPLOYEE SET SALARY = 0; (여러 행에 대해 자료가 변경되지만 해당 SQL에 대해 한 번만 트리거 실행)

### 표현식

```
CREATE OR REPLACE TRIGGER 트리거 명
BEFORE | AFTER
INSERT | UPDATE | DELETE
ON 테이블 명
[FOR EACH ROW] -- ROW TRIGGER 옵션
[WHEN 조건]
DECLARE
    선언부
BEGIN
    실행부
[EXCEPTION
    예외처리부]
END;
/
```

### 트리거 생성 예시

```MYSQL
-- EMPLOYEE테이블에 사원이 추가되면 '신입사원이 입사했습니다'라는 문구 출력되는 TRG_01 트리거 생성

CREATE OR REPLACE TRIGGER TRG_01
AFTER
INSERT
ON EMPLOYEE
BEGIN
    DBMS_OUTPUT.PUT_LINE('신입사원이 입사했습니다');
END;
/
```


