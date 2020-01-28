# 스레드 (Thread)

## 프로세스 (Process)

간단한 의미로 **실행 중인 프로그램**입니다.<br>
프로세스는 프로그램이 실행될 때마다 개별적으로 생성합니다.<br>
하나의 프로세스는 프로그램을 수행함에 있어 필요한 데이터와 메모리 등의<br>
할당 받은 자원, 그리고 **하나 이상의 스레드**로 구성됩니다.

## 스레드 (Thread)

**프로세스 내**에서 할당된 자원을 이용해서 **실제 작업을 수행**하는 작업단위입니다.<br>
모든 프로세스는 하나 이상의 스레드를 가지며 각각 독립적인 작업단위를 가집니다.

#### 메인 스레드

모든 자바 프로그램은 메인 스레드가 main() 메소드를 실행하며 시작합니다.<br>
main()의 첫 코드부터 아래로 순차적으로 실행되고, return을 만나면 종료됩니다.<br>
필요에 의해 작업 스레드들을 만들어서 병렬 코드 실행 가능합니다.<br>
(멀티 스레드를 이용한 멀티 태스킹)

#### 프로세스 종료

싱글 스레드의 경우 메인 스레드가 종료되면 프로세스도 종료되지만,<br>
멀티 스레드의 경우 실행 중인 스레드가 하나라도 있다면 프로세스가 종료되지 않습니다.

### 싱글 스레드

메인 스레드 하나만 가지고 작업을 처리합니다.<br>
-> 한 작업씩 차례대로 처리해 나감

### 멀티 스레드

메인 스레드 외의 추가적인 스레드를 이용하여 병렬적으로 작업을 처리합니다.

#### 장점

\- 자원을 보다 효율적으로 사용 가능<br>
\- 사용자의 대한 응답성 향상<br>
\- 애플리케이션의 응답성 향상<br>
\- 작업이 분리되어 코드가 간결해짐<br>
\- CPU 사용률 향상<br>

#### 단점

\- 동기화(Synchronization)에 주의

```
동기화 : 하나의 자원에 하나의 스레드만 접근할 수 있도록 하는 것입니다.
```

\- 교착상태(dead-lock)가 발생하지 않도록 주의
```
교착상태 : 두 개 이상의 작업이 서로 상대방의 작업이 끝나기 만을 기다리고 있기 때문에 아무것도 완료되지 못하는 상태입니다.
```

### 스레드 생성

#### 1. Thread 클래스 상속

```java
public class 클래스명 extends Thread{
	// 상속 처리 후, run() 메소드 오버라이딩

	@Override
	public void run(){
		// 작업하고자 하는 코드 작성
	}
}
```

```java
public class Run {
	public static void main(String[] args) {
		클래스명 레퍼런스 = new 생성자(); // Thread를 상속한 객체 생성
		
		레퍼런스.start();
	}
}
```

#### 2. Runnable 인터페이스 구현

```java
public class 클래스명 implements Runnable {
	// 상속 처리 후, run() 메소드 오버라이딩

	@Override
	public void run(){
		// 작업하고자 하는 코드 작성
	}
}
```

```java
public class Run {
	public static void main(String[] args) {
		클래스명 레퍼런스 = new 생성자(); // Runnable을 구현한 객체 생성
		
		Thread thread = new Thread(레퍼런스);
		thread.start();
	}
}
```

### 스레드 스케줄링

스레드 개수가 코어의 수보다 많을 경우 스레드를 어떤 순서로 동시성을 실행할 것인가를 결정하는 것으로<br>
스케줄링에 의해 스레드들은 번갈아가며 run() 메소드를 조금씩 실행합니다.

#### 우선 순위 방식 (Priority)

\- 우선 순위가 높은 스레드가 작업 시간을 더 많이 가지도록 하는 스케줄링 방식<br>
\- 스레드에 1 ~ 10 까지 우선 순위 번호 부여 가능 (번호가 높을수록 우선 순위가 높음)<br>
\- 스레드 생성 시 우선 순위 기본값은 5

```java
public class Run {
	public static void main(String[] agrs) {
		클래스명 레퍼런스 = new 생성자(); // Thread를 상속한 객체 생성
		
		레퍼런스.setPriority(1 ~ 10);
	}
}
```

### 스레드 컨트롤

실행 중인 스레드의 상태를 제어하기 위한 것으로 효율적이고 정교한 스케줄링을 위한 스레드 상태를 제어하는 기능입니다.

![스레드컨트롤](https://github.com/kleg26315/TIL/blob/master/resources/%EC%8A%A4%EB%A0%88%EB%93%9C%EC%BB%A8%ED%8A%B8%EB%A1%A4.PNG)

InterruptedException이 발생하면 isInterrupted가 true가 되도 false로 초기화시켜줍니다.


### 동기화 (Synchronized)

한 번에 한 개의 스레드만 프로세스 공유 자원(객체)에 접근할 수 있도록 락(Lock)을 걸어 다른 <br>
스레드가 진행 중인 작업에 간섭하지 못 하도록 하는 것입니다.

* 동기화 메소드

```java
public synchronized void method() {
	// 한 개의 스레드만 실행할 수 있음
}
```

* 동기화 블록

```java
public void method1() {
	// 여러 스레드 실행할 수 있음

	synchronized (공유객체) {
		// 한 개의 스레드만 실행할 수 있음
	}
	// 여러 스레드 실행할 수 있음
}
```

즉, 공유 객체에 일반 메소드는 여러 스레드가 동시 접근할 수 있지만<br>
동기화 메소드와 동기화 블록은 한 스레드가 이미 접근하고 있으면 다른 스레드는 접근할 수 없습니다.

![스레드동기화](https://github.com/kleg26315/TIL/blob/master/resources/%EC%8A%A4%EB%A0%88%EB%93%9C%EB%8F%99%EA%B8%B0%ED%99%94.PNG)





