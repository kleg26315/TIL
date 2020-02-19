## SYNONYM (동의어)

사용자가 다른 사용자의 객체를 참조할 때 [사용자ID].[테이블명]으로<br>
표시하는데 이처럼 길게 표현되는 것을 동의어(SYNONYM)로 설정 후 간단히 사용 가능한 객체입니다.

즉, 다른 DB가 가진 객체에 대한 별명 혹은 줄임말로 동의어를 사용하여 간단하게 접근할 수 있도록 합니다.

### 비공개 동의어

객체에 대한 접근 권한을 부여 받은 사용자가 정의한 동의어로 해당 사용자만 사용 가능합니다.

```MYSQL
GRANT CREATE SYNONYM TO KH; -- (SYSTEM계정)

CREATE SYNONYM EMP FOR EMPLOYEE;
```

### 공개 동의어

권한을 주는 사용자(DBA)가 정의한 동의어로 모든 사용자가 사용 가능(PUBLIC)합니다. ex) DUAL

```MYSQL
CREATE PUBLIC SYNONYM DEPT FOR KH.DEPARTMENT;

-- 동의어 삭제
DROP SYNONYM EMP;
DROP PUBLIC SYNONYM DEPT;
```
