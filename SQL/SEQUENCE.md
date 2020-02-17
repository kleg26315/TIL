## SEQUENCE

순차적으로 정수 값을 자동으로 생성하는 객체로 **자동 번호 발생기(생성기)** 역할을 합니다.

### 표현식

```
CREATE SEQUENCE 시퀀스명
① [START WITH 숫자]  -> 처음 발생시킬 시작 값, 기본값 1
② [INCREMENT BY 숫자] ->  다음 값에 대한 증가치, 기본값 1
③ [MAXVALUE 숫자 | NOMAXVALUE] ->   발생시킬최대값, 10의27승-1까지가능
④ [MINVALUE 숫자 | NOMINVALUE] ->  발생시킬 최소값, -10의 26승
⑤ [CYCLE | NOCYCLE]  ->  시퀀스가 최대값까지 증가 완료 시
			CYCLE은START WITH 설정값으로돌아감
			NOCYCLE은 에러 발생
⑥ [CACHE | NOCACHE] ->  CACHE는 메모리 상에서 시퀀스 값 관리, 기본값 20
```

### SEQUENCES 사용
* 시퀀스명.CURRVAL : 현재 생성된 시퀀스의 값

```MYSQL
SELECT SEQ_EMPID.CURRVAL FROM DUAL;
-- ORA-08002: sequence SEQ_EMPID.CURRVAL is not yet defined in this session
-- 아직 시퀀스를 만들기만 했지 시퀀스명.NEXTVAL로 시퀀스를 실행시키지 않았기 때문에
```

* 시퀀스명.NEXTVAL : 시퀀스를 증가시키거나 최초로 시퀀스 실행

시퀀스명.NEXTVAL = 시퀀스명.CURRVAL + INCREMENT로 지정한 값

### CURRVAL / NEXTVAL 사용 가능 및 불가능

#### 사용 가능
* 서브쿼리가 아닌 SELECT 문
*  INSERT문의 SELECT절
*  INSERT문의 VALUES절
*  UPDATE문의 SET절

### 사용 불가능
* VIEW의 SELECT절
*  DISTINCT 키워드가 있는 SELECT문
*  GROUP BY, HAVING, ORDER BY절의 SELECT문
*  SELECT, UPDATE, DELETE문의 서브쿼리
*  CREATE TABLE, ALTER TABLE의 DEFAULT 값

### 시퀀스 변경

```MYSQL
-- 시퀀스 변경
ALTER SEQUENCE SEQ_EMPID
INCREMENT BY 10
MAXVALUE 400
NOCYCLE
NOCACHE;

-- START WITH 값 변경 불가!
```
