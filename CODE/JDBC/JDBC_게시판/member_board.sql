-- 관리자 계정으로 실행

--CREATE USER member IDENTIFIED BY member;

--GRANT CONNECT, RESOURCE TO member;

--------------------------------------------------------
-- member계정으로 실행

DROP TABLE MEMBER;

CREATE TABLE MEMBER (
  MEMBER_ID VARCHAR2(30) PRIMARY KEY, 
  MEMBER_PWD VARCHAR2(30) NOT NULL,
  MEMBER_NAME VARCHAR2(30) NOT NULL,
  GENDER char(1) CHECK(GENDER IN('M','F')),
  EMAIL VARCHAR2(50),
  PHONE VARCHAR2(30),
  ADDRESS VARCHAR2(100),
  AGE NUMBER,
  ENROLL_DATE DATE DEFAULT SYSDATE -- 가입일
);
SELECT COUNT(*) FROM MEMBER WHERE MEMBER_ID = 'user01';
INSERT INTO MEMBER VALUES ('user01', 'pass01', '홍길동', 'M', 'hong_gd@kh.or.kr', '010-1234-1234', '경기도 남양주시 지금동', '20', sysdate);
INSERT INTO MEMBER VALUES ('user02', 'pass02', '김유신', 'M', 'kim_ys@kh.or.kr', '010-1234-1234', '경기도 시흥시 정왕동', '19', sysdate);
INSERT INTO MEMBER VALUES ('user03', 'pass03', '이순신', 'M', 'lee_ss@kh.or.kr', '010-1234-1234', '서울시 강남구 역삼동', '12', sysdate);
INSERT INTO MEMBER VALUES ('user04', 'pass04', '김영희', 'F', 'kim_yh@kh.or.kr', '010-1234-1234', '서울시 관악구 봉천동', '27', sysdate);
INSERT INTO MEMBER VALUES ('user05', 'pass05', '박철수', 'M', 'park_cs@kh.or.kr', '010-1234-1234', '경기도 수원시 연무동', '20', sysdate);
INSERT INTO MEMBER VALUES ('user06', 'pass06', '유재석', 'F', 'you_js@kh.or.kr', '010-1234-1234', '인천광역시 계양구 동양동', '20', sysdate);

COMMIT;

SELECT * FROM MEMBER;

-- BOARD 테이블 생성
CREATE TABLE BOARD(
    BNO NUMBER PRIMARY KEY,
    TITLE VARCHAR2(50) NOT NULL,
    CONTENT VARCHAR2(400) NOT NULL,
    CREATE_DATE DATE DEFAULT SYSDATE,
    WRITER VARCHAR2(20),
    DELETE_YN CHAR(2) DEFAULT 'N',
    FOREIGN KEY (WRITER) REFERENCES MEMBER(MEMBER_ID),
    CHECK(DELETE_YN IN('Y','N'))
);

-- BOARD 테이블의 PK로 사용될 시퀀스
CREATE SEQUENCE SEQ_BOARD;

INSERT INTO BOARD VALUES(SEQ_BOARD.NEXTVAL,'안녕디지몬','누구세여',DEFAULT,'user01',DEFAULT);

commit;
