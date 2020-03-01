# JDBC

자바에서 데이터베이스에 접근할 수 있게 해주는 Programming API

![JDBC](https://github.com/kleg26315/TIL/blob/master/resources/JDBC.png)

## JDBC 사용 객체

### DriverManager

데이터 원본에 JDBC드라이버를 통하여 커넥션을 만드는 역할입니다.

**Class.forName() 메소드를 통해 생성**되며 반드시 예외처리를 해야 합니다.

직접 객체 생성이 불가능하고 **getConnection() 메소드를 사용하여 객체를 생성**합니다.

```java
Class.forName("oracle.jdbc.driver.OracleDriver");

Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "SCOTT");
// 연결정보를 담은 객체
// jdbc:oracle:thin		JDBC드라이버가 thin타입
// @localhost		오라클이 설치된 서버의 ip가 자신의 컴퓨터임 == @127.0.0.1
// 1521			오라클 listener 포트번호
// xe			접속할 오라클 명

System.out.println(conn); // 접속 실패 시 null
```

### Connection

특정 데이터 원본과 연결된 커넥션을 나타내며 Statement객체를 생성할 때도 Connection객체를 사용하여
createStatement() 메소드를 호출하여 생성합니다.<br>
즉, Connection안에는 연결된 계정에 대한 정보가 있습니다. 

SQL문장을 실행시키기 전에 우선 Connection 객체가 있어야 합니다.

### Statement

`Connection` 객체에 의해 프로그램에 리턴되는 객체에 의해 구현되는 일종의 메소드 집합 정의

Connection 클래스의 **createStatement()** 메소드를 호출하여 얻어지며(createStatement()의 반환 값이 Statement 객체)
 생성된 **Statement 객체**로 질의문장을 String 객체에 담아
인자로 전달하여 **executeQuery()** 메소드를 호출하여 SQL 질의를 수행합니다.

```java
String query = "SELECT * FROM EMP";

Statement stmt = conn.createStatement();
ResultSet rset = stmt.executeQuery(query);
```

### PreparedStatement

`Connection` 객체의 **prepareStatement()** 메소드를 사용하여 PreparedStatement 객체 생성

SQL문장이 미리 컴파일 되고 실행 시간 동안 인수 값을 위한 공간을 확보한다는 점에서 Statement와 다릅니다.

각 인수에 대해 위치홀더(?)를 사용해 SQL문장을 정의할 수 있게 합니다.

```java
String query = "SELECT * FROM EMP WHERE EMPNO = ?"; // 위치홀더는 작은따옴표가 자동으로 들어감

PreparedStatement pstmt = conn.prepareStatement(query);
pstmt.setInt(1, empNo);

ResultSet rset = pstmt.executeQuery();
```

### ResultSet

SELECT문을 사용한 질의 성공 시 ResultSet을 반환합니다.

SQL질의에 의해 생성된 테이블을 담고 있으며 커서(cursor)로 특정 행에 대한 참조를 조작합니다.

```java
ResultSet rset = stmt.executeQuery(query);

empList = new ArrayList<>(); // 조회 결과를 저장할 ArrayList
Employee emp = null; // 조회 결과의 한 행의 값을 저장할 임시 vo 선언

while(rset.next()) {
	int empNo = rset.getInt("empno");
	String empName = rset.getString("ename");
	String job = rset.getString("job");
	int mgr = rset.getInt("mgr");
	Date hireDate = rset.getDate("hiredate");
	int sal = rset.getInt("sal");
	int comm = rset.getInt("comm");
	int deptNo = rset.getInt("deptno");
				
	emp = new Employee(empNo, empName, job, mgr, hireDate, sal, comm, deptNo);
	empList.add(emp);
}
```

### Statement와 PreparedStatement의 차이점

Statement는 보내고 싶은 쿼리문을 완성해서 직접 보내는 역할이고

PreparedStatement는 쿼리문을 미완성해서 보내는 역할입니다. (위치홀더 '?' 사용)

### executeQuery()와 executeUpdate()의 차이점

executeQuery()는 보낼 쿼리가 select일 때 쓰는 것이고 반환값은 resultSet(SELECT했을 때 나온 행들의 집합)입니다.

executeUpdate()는 보낼 쿼리가 insert이거나 update이거나 delete일 때 사용합니다.<br>
insert나 update나 delete는 반환값이 0(실패) 또는 1(성공)이라 반환값이 int 입니다.


