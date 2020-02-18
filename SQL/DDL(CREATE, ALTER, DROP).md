# DDL (CREATE)

데이터 정의 언어로 객체(OBJECT)를 만들고(CREATE), 수정하고(ALTER), 삭제(DROP)하는 구문을 말합니다.

* 오라클 객체 종류

```
테이블(TABLE), 뷰(VIEW), 시퀀스(SEQUENCE), 인덱스(INDEX),
패키지(PACKAGE), 프로시저(PROCEDUAL), 함수(FUNCTION),
트리거(TRIGGER), 동의어(SYNONYM), 사용자(USER)
```

## CREATE

테이블이나 인덱스, 뷰 등 데이터베이스 객체를 생성하는 구문

### 오라클 데이터형

|데이터형|설명|
|:---:|:---:|
|CHAR(크기)|고정길이 문자 데이터|
|VARCHAR2(크기)|가변길이 문자 데이터(최대 2,000 Byte)|
|NUMBER|숫자 데이터 (최대 40자리)|
|NUMBER(길이)|숫자 데이터로, 길이 지정 가능 (최대 38자리)|
|DATE|날짜 데이터(BC 4712년 1월 1일 ~ AD 4712년 12월 31일)|
|LONG|가변 길이 문자형 데이터(최대 2GB)|
|LOB|2GB까지의 가변길이 바이너리 데이터 저장 가능<br>(이미지, 실행파일 등 저장 가능)|
|ROWID|DB에 저장되지 않는 행을 식별할 수 있는 고유 값|
|BFILE|대용량의 바이너리 데이터 저장 가능(최대 4GB)|
|TIMESTAMP|DATE형의 확장된 형태|
|INTERVAL YEAR TO MONTH|년과 월을 이용하여 기간 저장|
|INTERVAL DAY TO SECOND|일, 시, 분, 초를 이용하여 기간 저장|

### 컬럼 주석

테이블의 컬럼에 주석을 다는 구문입니다.

```MYSQL
COMMENT ON COLUMN 테이블명.컬럼명 IS '주석 내용 ';

COMMENT ON COLUMN MEMBER.MEMBER_ID IS '회원아이디';
```

### 제약 조건 (CONSTRAINTS)

테이블 작성 시 각 컬럼에 기록될 데이터에 대해 제약 조건을 설정할 수 있는데 이는 **데이터 무결성 보장을 주 목적**으로 합니다.<br>
입력 데이터에 문제가 없는지에 대한 검사와 데이터 수정/삭제 가능 여부 검사 등을 위해 사용합니다.

제약조건은 테이블을 처음 만들 때 지정해도 되고 나중에 테이블을 만들고 나서 지정해도 됩니다.

|제약 조건|설명|
|:---:|:---:|
|NOT NULL|데이터에 NULL을 허용하지 않음(NULLABLE)|
|UNIQUE|중복된 값을 허용하지 않음|
|PRIMARY KEY(PK)|NULL과 중복 값을 허용하지 않음<br>(**컬럼의 고유 식별자**로 사용하기 위해)|
|FOREIGN KEY(FK)|참조되는 테이블의 컬럼의 값이 존재하면 허용<br>참조되는 값은 제공되는 값 외에 NULL만을 사용 가능|
|CHECK|저장 가능한 데이터 값의 범위나 조건을 지정하여 설정한 값만 허용|

#### NOT NULL
* NULL값을 허용하지 않도록 *컬럼레벨*에서 제한
* 해당 컬럼에 반드시 값이 기록되어야 하는 경우 사용
* 특정 컬럼에 값을 저장/수정할 때는 NULL값을 허용하지 않도록 컬럼 레벨에서 제한

### UNIQUE
* 컬럼 입력 값에 대해서 중복을 제한하는 제약조건
* *컬럼 레벨과 테이블 레벨*에서 설정 가능

### 제약 조건에 이름 설정

```MYSQL
CREATE TABLE CONS_NAME(
    TEST_DATA1 VARCHAR2(20) CONSTRAINT NN_TEST_DATA1 NOT NULL,
    TEST_DATA2 VARCHAR2(20) CONSTRAINT NN_TEST_DATA2 NOT NULL,
    TEST_DATA3 VARCHAR2(20),
    CONSTRAINT UK_TEST_DATA3 UNIQUE(TEST_DATA3)
);

INSERT INTO CONS_NAME
VALUES('TEST1','TEST2','TEST3');	// 정상 삽입

INSERT INTO CONS_NAME
VALUES('TEST1','TEST2','TEST3');	// 에러

// 에러메시지 : unique constraint (KH.UK_TEST_DATA3) violated
// 어떤 에러인지 명시적으로 나타내주기 때문에 에러 식별이 쉬움
```

### PRIMARY KEY
* NOT NULL + UNIQUE
* 한 행을 구분할 수 있는 고유 식별자 역할
* 한 테이블 당 하나만 설정 가능, 컬럼레벨/테이블레벨 둘 다 설정 가능
* 한 개 컬럼에 설정할 수 있고 여러 개 컬럼을 묶어서 설정할 수 있음

### FOREIGN KEY
* 참조된 다른 테이블이 제공하는 값만 사용할 수 있음
* 제공되는 값 외에는 NULL 사용 가능

### CHECK
* 컬럼에 기록되는 값에 조건 설정 (변하는 값, 함수 사용 불가능)
* 비교 연산자를 이용하여 조건을 설정하며 비교 값을 리터럴만 사용 가능

## 삭제 옵션

부모 테이블의 데이터 삭제 시 자식 테이블의 데이터를 어떤 식으로 처리할 지에 대한 내용을 설정해야 합니다.

ON DELETE RESTRICTED(삭제 제한)로 기본 지정되어 있고<br>
FOREIGN KEY로 지정된 컬럼에서 사용되고 있는 값일 경우 제공하는 컬럼의 값은 삭제하지 못 합니다.

### SET NULL
* 부모 키 삭제 시 자식 키를 NULL로 변경

### CASCADE
* 부모 키 삭제 시 자식 키도 함께 삭제(행까지)

### 제약조건 추가
* ALTER 구문으로 제약조건을 변경 및 추가할 수 있음
* UNIQUE, CHECK, PRIMARY KEY, FOREIGN KEY 는 ADD로 제약조건을 변경하지만 NOT NULL은 MODIFY로 변경합니다.

```MYSQL
ALTER TABLE USER_GRADE4 ADD PRIMARY KEY(GRADE_CODE);
ALTER TABLE USER_FOREIGNKEY4 ADD UNIQUE(USER_ID);
ALTER TABLE USER_FOREIGNKEY4 ADD CHECK(GENDER IN ('남', '여'));
ALTER TABLE USER_FOREIGNKEY4 ADD FOREIGN KEY(GRADE_CODE) REFERENCES USER_GRADE4;
ALTER TABLE USER_FOREIGNKEY4 MODIFY USER_PWD NOT NULL;
```

# DDL (Data Definition Language)

데이터 정의 언어로 객체(OBJECT)를 만들고(CREATE), 수정하고(ALTER), 삭제(DROP)하는 구문을 말합니다.

## ALTER

테이블에 정의된 내용을 수정할 때 사용하는 데이터 정의어로 컬럼의 추가/삭제, 제약조건의 추가/삭제, <br>
컬럼의 자료형 변경 DEFAULT 값 변경, 테이블 명/컬럼 명/제약조건 명 변경 등을 할 수 있습니다.

### 컬럼 추가

```MYSQL
ALTER TABLE DEPT_COPY
ADD (CNAME VARCHAR2(20));

-- 컬럼 추가 시 DEFAULT 값 지정
ALTER TABLE DEPT_COPY
ADD (LNAME VARCHAR2(40) DEFAULT '한국');
```

### 컬럼 수정

```MYSQL
ALTER TABLE DEPT_COPY
MODIFY DEPT_ID CHAR(3)
MODIFY DEPT_TITLE VARCHAR2(30)
MODIFY LOCATION_ID VARCHAR2(2)
MODIFY CNAME CHAR(20)
MODIFY LNAME DEFAULT '미국';

ALTER TABLE DEPT_COPY
MODIFY DEPT_TITLE VARCHAR2(10);
-- cannot decrease column length because some value is too big
```

### 컬럼 삭제
* 데이터가 기록되어 있어도 삭제 가능
* 삭제한 컬럼은 복구 불가
* 테이블에는 최소 한 개의 컬럼이 존재해야 함 : 모든 컬럼 삭제 불가

```MYSQL
ALTER TABLE DEPT_COPY2
DROP COLUMN DEPT_ID;
```

### 제약 조건 추가

```MYSQL
ALTER TABLE USER_FOREIGNKEY4 ADD UNIQUE(USER_ID);
ALTER TABLE USER_FOREIGNKEY4 ADD CHECK(GENDER IN ('남', '여'));
ALTER TABLE USER_FOREIGNKEY4 ADD FOREIGN KEY(GRADE_CODE) REFERENCES USER_GRADE4;
ALTER TABLE USER_FOREIGNKEY4 MODIFY USER_PWD NOT NULL;  -- NOT NULL 제약조건은 ADD가 아닌 MODIFY로 해야함!
```

### 제약 조건 삭제

```MYSQL
ALTER TABLE DEPT_COPY
DROP CONSTRAINT SYS_C007085;
```

### 컬럼, 제약조건, 테이블 이름 변경

* 컬럼 이름 변경

```MYSQL
ALTER TABLE DEPT_COPY
RENAME COLUMN DEPT_TITLE TO DEPT_NAME;
```

* 제약조건 이름 변경

```MYSQL
ALTER TABLE USER_FOREIGNKEY
RENAME CONSTRAINT SYS_C007065 TO UF_UP_NN;
```

* 테이블 이름 변경

```MYSQL
ALTER TABLE DEPT_COPY
RENAME TO DEPT_TEST;
```

## DROP

데이터베이스 객체를 삭제하는 구문입니다.

```MYSQL
DROP TABLE DEPT_TEST
CASCADE CONSTRAINTS;
```
