-- ������ �������� ����

--CREATE USER member IDENTIFIED BY member;

--GRANT CONNECT, RESOURCE TO member;

--------------------------------------------------------
-- member�������� ����

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
  ENROLL_DATE DATE DEFAULT SYSDATE -- ������
);
SELECT COUNT(*) FROM MEMBER WHERE MEMBER_ID = 'user01';
INSERT INTO MEMBER VALUES ('user01', 'pass01', 'ȫ�浿', 'M', 'hong_gd@kh.or.kr', '010-1234-1234', '��⵵ �����ֽ� ���ݵ�', '20', sysdate);
INSERT INTO MEMBER VALUES ('user02', 'pass02', '������', 'M', 'kim_ys@kh.or.kr', '010-1234-1234', '��⵵ ����� ���յ�', '19', sysdate);
INSERT INTO MEMBER VALUES ('user03', 'pass03', '�̼���', 'M', 'lee_ss@kh.or.kr', '010-1234-1234', '����� ������ ���ﵿ', '12', sysdate);
INSERT INTO MEMBER VALUES ('user04', 'pass04', '�迵��', 'F', 'kim_yh@kh.or.kr', '010-1234-1234', '����� ���Ǳ� ��õ��', '27', sysdate);
INSERT INTO MEMBER VALUES ('user05', 'pass05', '��ö��', 'M', 'park_cs@kh.or.kr', '010-1234-1234', '��⵵ ������ ������', '20', sysdate);
INSERT INTO MEMBER VALUES ('user06', 'pass06', '���缮', 'F', 'you_js@kh.or.kr', '010-1234-1234', '��õ������ ��籸 ���絿', '20', sysdate);

COMMIT;

SELECT * FROM MEMBER;

-- BOARD ���̺� ����
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

-- BOARD ���̺��� PK�� ���� ������
CREATE SEQUENCE SEQ_BOARD;

INSERT INTO BOARD VALUES(SEQ_BOARD.NEXTVAL,'�ȳ������','��������',DEFAULT,'user01',DEFAULT);

commit;
