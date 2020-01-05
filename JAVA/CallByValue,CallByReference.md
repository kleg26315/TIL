프로그래밍 언어에서 변수를 다른 함수의 인자로 넘겨줄 수 있습니다. 
이때 이 변수의 **값을 넘겨주는 호출 방식**을 **Call by Value(CBV)**, 
이 변수의 **참조값(혹은 주소, 포인터)를 넘겨 주는 호출 방식**을 **Call by Reference(CBR)**라고 합니다.

## Call by Value, 값에 의한 호출

함수에서 값을 복사해서 전달하는 방식으로, 인자로 전달되는 변수를 함수의 매개변수에 복사합니다.

이렇게 복사되면 인자로 전달한 변수와는 별개의 변수가 되며, 매개변수를 변경해도 원래의 변수에는 영향을 미치지 않습니다.

따라서 원본 값을 바꿀 필요가 없는 경우에는 call by value 방식을 이용하면 됩니다.

* call by value의 대표적인 예제인 swap 함수 코드입니다.
```java
static void swap(int x, int y){
	int tmp = x;
	x = y;
	y = tmp;
}

public static void main(String[] args){
	int a = 1;
	int b = 2;
	System.out.println("a: "+a+", b"+b);	// a:1 , b:2
	swap(a,b);
	System.out.println("a: "+a+", b"+b);	// a:1 , b:2
}
```

위 코드에서 main함수가 swap함수를 호출할 때 swap함수가 필요로 하는 a와 b값(1과 2)을 복사해서 넘겨줍니다.

swap함수는 함수가 실행될 때 stack에 x, y, tmp 세 임시 저장공간을 만들었다가 전달받은 1과 2를 각각 x와 y에 저장한 후
함수 내 코드를 실행합니다.

swap 함수는 종료할 때 임시로 생성했던 모든 공간을 삭제하므로 x, y, tmp로 작업했던 내용은 모두 사라지게 되고,
main 함수의  a와 b는 그대로 1과 2를 유지하고 있습니다. 

요약하자면, x 와 y 그리고 a와 b는 아무런 관련이 없는 독립적인 변수들입니다.

## Call by Reference, 참조에 의한 호출

함수에서 값을 전달하는 대신 주소값을 전달하는 방식을 call by reference라고 합니다. 

즉 메소드 호출 시 사용되는 인자 값의 메모리에 저장되어 있는 주소(address)를 복사하여 보냅니다.

C언어는 포인터로 CBR을 구현할 수 있습니다. 사실 엄밀히 따지면, C언어에서의 방식은 주소값 자체를 복사해서 넘겨주는 것이므로 CBV입니다.

또한 이렇게 주소값을 복사해서 넘겨주는 것을 call by address 방식이라고 합니다. C언어에서는 call by reference를 공식적으로 지원하지 않습니다.


그러나 의미적, 결과적으로 call by address를 이용해서 call by reference와 같이 사용할 수 있기 때문에 
일반적으로 C언어에서 포인터를 이용해 주소값을 넘겨주는 방식을 CBR이라고 설명합니다.

## Parameter passing in Java : CBV vs CBR ?

우선 결론부터 말씀드리자면 **자바는 Call by value 방식**입니다.

```java
class MyClass{
	int index;

	public MyClass(int index){
		this.index = index;
	}

	public int getIndex(){
		return index;
	}

	public void setIndex(){
		this.index = index;
	}
}
```
위와 같이 멤버 변수를 하나 가진 클래스가 있습니다. 이 클래스를 이용하여 객체를 변경해보고, 객체의 멤버변수 값을 변경해보겠습니다.

### 1. 객체 바꿔보기

```java
public class JavaCallByValue{
	public static void main(String[] args){
		MyClass myClass1 = new MyClass(1);
		MyClass myClass2 = new MyClass(2);

		// 두개의 참조를 바꿔 보자
		swapReference(myClass1, myClass2);
		System.out.println(myClass1.getIndex());	// 출력결과 1
		System.out.println(myClass2.getIndex());	// 출력결과 2
	}

	static void swapReference(MyClass m1, MyClass m2) {
		MyClass tmp = m1;
		m1 = m2;
		m2 = tmp;
	}
}
```

필드가 하나 있는 간단한 클래스를 선언한 후 두개의 객체를 생성하여 각각의 index 필드 값을 1과 2로 지정하였습니다.
swapReference() 함수를 이용하여 두 개의 객체를 바꿔보면 필드값이 바뀌지 않고 1, 2로 출력됩니다.

이를 통해 자바는 call by reference가 아님을 확인할 수 있습니다.

### 2. 필드 값 바꿔보기

```java
public class JavaCallByValue{
	public static void main(String[] args){
		MyClass myClass1 = new MyClass(1);
		MyClass myClass2 = new MyClass(2);

		// 두개의 참조를 바꿔 보자
		swapReference(myClass1, myClass2);
		System.out.println(myClass1.getIndex());	// 출력결과 2
		System.out.println(myClass2.getIndex());	// 출력결과 1
	}

	static void swapReference(MyClass m1, MyClass m2) {
		int tmpIndex = m1.getIndex();
		m1.setIndex(m2.getIndex());
		m2.setIndex(tmpIndex);
	}
}
```

이번에는 객체의 필드 값을 바꿔보았습니다. 그 결과 서로 값이 바뀌어 출력이 됐습니다. 

이러한 결과가 나오는 이유는, 자바가 함수의 인자로 전달해주는 것은 "어떤 것을 참조하고 있는지에 대한 참조값"을 전달해주기 때문입니다.

1번 예제의 경우 참조값을 받아서 그 참조값들을 다른 스택에서 변경하는 것은 아무런 의미가 없습니다. 
하지만 참조값을 받아서 그 참조값을 이용하는 것은 가능하기 때문에 객체의 필드 값이 바뀌어 출력됩니다.

--------------------------------------------------------------------------------------------

정리하자면, 자바는 기본형 변수타입과 참조형 변수타입이 있는데 둘 다 상관없이 call by value 방식으로 메소드에서 받아집니다.

대신 기본형 타입은 그 값을 복사해서 주지만 참조형 타입은 값의 래퍼런스(주소)가 저장되는 것이므로 그 값의 래퍼런스가 복사되어집니다.

즉, **값의 래퍼런스가 call by value 방식**으로 넘어갑니다.

## *Reference
* [https://edu.goorm.io/learn/lecture/201/](https://edu.goorm.io/learn/lecture/201/%EB%B0%94%EB%A1%9C-%EC%8B%A4%ED%96%89%ED%95%B4%EB%B3%B4%EB%A9%B4%EC%84%9C-%EB%B0%B0%EC%9A%B0%EB%8A%94-c%EC%96%B8%EC%96%B4/lesson/412515/call-by-value-and-call-by-reference)
* https://sleepyeyes.tistory.com/11
* http://mussebio.blogspot.com/2012/05/java-call-by-valuereference.html
* https://hyoje420.tistory.com/6
