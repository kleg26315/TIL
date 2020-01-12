## 다형성 (Polymorphism)

객체지향 프로그래밍의 3대 특징 중 하나로 '여러 개의 형태를 갖는다'는 의미로
하나의 행동으로 여러 가지 일을 수행하는 개념입니다.
상속을 이용해 부모 타입으로부터 파생된 여러 가지 타입의 자식 객체를 부모 클래스 타입 하나로 다룰 수 있는 기술입니다.

즉, 부모클래스 타입 하나로 자식 객체들을 받을 수 있는 기술입니다.

다형성의 전제는 상속이 되어 있어야합니다.

```java
public void method() {
	System.out.println("1. 부모타입 레퍼런스로 부모 객체를 다루는 경우");
	Parent p = new Parent();
	p.printParent();		// 출력 : 나 부모야
		
	System.out.println("2. 자식타입 레퍼런스로 자식 객체를 다루는 경우");
	Child1 c1 = new Child1();
	c1.printChild1();		// 출력 : 나 첫 번째 자식이야
	c1.printParent();		// 출력 : 나 부모야
		
	System.out.println("3. 부모타입 레퍼런스로 자식 객체를 다루는 경우");
	Parent p2 = new Child2();	// (업캐스팅 : 부모타입의 참조형 변수가 모든 자식 객체를 받을 수 있는 것)
	p2.printParent();			// Parent 메소드만 확인 가능함
	((Child2)p2).printChild2(); // (다운캐스팅 : 부모타입의 참조형 변수가 자식의 멤버를 참조해야할 경우,
                              // 형변환을 통해 Child2 메소드까지 확인 가능함)
	
	System.out.println("4. 자식타입 레퍼런스로 부모 객체를 다루는 경우");
	Child2 c2 = new Parent();	// 에러 : 부모는 자식을 받을 수 있지만 자식은 부모를 받을 수 없다.
	// Type mismatch: cannot convert from Parent to Child2
	// 3번은 p2는 child2로 생성된 객체를 확인하면 child2 method와 parent method를 포함하여 가지고 있기 때문에 
	// 이미 가지고있는것에서 달라는 것이기때문에 에러가 나지 않지만
	// 이 경우는 child2가 보는 것이 parent로 생성된 parent 밖에 없기때문에 에러가 남
}
```

위에 코드를 메모리영역에 그려 표현해보았습니다. 
![다형성객체생성](https://github.com/kleg26315/TIL/blob/master/resources/%EB%8B%A4%ED%98%95%EC%84%B1%EA%B0%9D%EC%B2%B4%EC%83%9D%EC%84%B1.png)

## instanceof 연산자

현재 참조형 변수(=래퍼런스 변수, 클래스)가 어떤 클래스 형의 객체 주소를 참조하고 있는지 확인 할 때 사용하는 연산자로 클래스 타입이 맞으면
true, 맞지 않으면 false를 반환합니다.

* 표현식

```java
if(레퍼런스 instanceof 클래스타입) {
//true일 때 처리할 내용, 해당 클래스 타입으로 down casting
}
```

* Example

```java
public void execute(){
	driveCar(new Sonata());
	driveCar(new Avante());
	driveCar(new Grandure());
}

public void driveCar(Car c){
	if( c instanceof Sonata) {
		((Sonata)c).moveSonata();
	} else if ( c instanceof Avante){
		((Avante)c).moveAvante();
	} else if ( c instanceof Grandure){
		((Grandure)c).moveGrandure();
	}
}
```

## 바인딩

**오버라이딩의 자식 객체를 통한 실행 시 후손 것이 우선권을 가지는 특징**때문에 동적바인딩이 됩니다.

바인딩이란 실제 실행할 메소드 코드와 호출하는 코드를 연결 시키는 것으로 프로그램이 실행되기 전에 컴파일이 되면서
모든 메소드는 정적 바인딩 됩니다.

* 동적 바인딩

컴파일 시 정적 바인딩된 메소드를 실행할 당시의 객체 타입을 기준으로 바인딩 되는 것입니다.

* 동적 바인딩 성립 요건

상속 관계로 이루어져 다형성이 적용된 경우, 메소드 오버라이딩이 되어 있으면 정적으로 바인딩 된 메소드 코드보다

오버라이딩 된 메소드 코드를 우선적으로 수행합니다.

* Example

```java
public void method() {
  Parent[] pArr = new Parent[4];
	pArr[0] = new Child1();
	pArr[1] = new Child2();
	pArr[2] = new Child1();
	pArr[3] = new Child2();
	
	for(int i =0; i< pArr.length; i++) {
		if(pArr[i] instanceof Child1) {
			((Child1)pArr[i]).printChild1();		// 1번
		} else if (pArr[i] instanceof Child2) {
			((Child2)pArr[i]).printChild2();		// 2번
		}
	}
	
	for(int i =0; i<pArr.length; i++) {
		pArr[i].print();				// 3번
	}
}
```

print 메소드는 Parent의 메소드로 Child1 과 Child2 모두 print 메소드를 오버라이딩했다고 가정하겠습니다.

코드에서 객체 배열을 생성해주고 인덱스마다 부모 레퍼런스로 자식 객체를 생성했습니다.

1번과 2번 같은 경우는 instanceof 연산자를 통하여 다운캐스팅을 알맞게 하여 자식클래스의 메소드들을 사용할 수 있습니다.

3번은 다운캐스팅을 하지 않으면 앞서 그렸던 메모리영역을 생각하면 Parent 메소드들만 확인 가능하니 Parent의 print() 메소드가

실행될 것이라고 생각할 것입니다. 하지만 실행을 하면 다운캐스팅을 하지 않았어도 오버라이딩 된 print메소드들은 자식클래스의 재정의된

print()메소드를 출력한 것을 확인할 수 있습니다.

이것이 자식 객체를 통한 실행 시 후손 것이 우선권을 가지는 오버라이딩의 특징때문에 동적바인딩이 된 것입니다.

## 추상 클래스

* 추상 클래스 (abstract class)

추상 클래스란 몸체 없는 메소드를 포함한 클래스입니다.

추상 클래스일 경우 클래스 선언부에 abstract 키워드를 사용하고 참조변수로 사용 가능합니다.

객체 생성하고 싶지 않을때 추상 클래스로 주로 만듭니다.

* 추상 메소드 (abstract method)

몸체 없는 메소드를 말합니다.

추상 메소드의 선언부에 abstract 키워드를 사용하고 상속 시 반드시 구현해야 하는, **오버라이딩이 강제화**되는 메소드입니다.

* 특징

1. 미완성 클래스 (abstract 키워드 사용) 자체적으로 객체 생성 불가 -> 반드시 상속하여 객체 생성

2. abstract 메소드가 포함된 클래스는 반드시 abstract 클래스, abstract 메소드가 없어도 abstract 클래스 선언 가능

3. 클래스 내에 일반 변수, 메소드 포함 가능

4. 객체 생성은 안되지만 참조형 변수 타입으로는 사용 가능

* 장점

장점으로는 일관된 인터페이스를 제공합니다.

꼭 필요한 기능을 강제화(공통적이나 자식클래스에서 특수화 되는 기능)하기 좋습니다.

## 인터페이스

인터페이스란 상수형 필드와 추상 메소드만을 작성할 수 있는 추상 클래스의 변형체로 

메소드 통일성을 부여하기 위해 **추상 메소드만** 따로 모아놓은 것으로 상속 시 인터페이스 내에 정의된 모든 추상 메소드를 구현해야 합니다.

```java
[접근제한자] interface 인터페이스명 {

	// 상수도 멤버로 포함할 수 있음
	public static final 자료형 변수명 = 초기값;
	
	// 추상 메소드만 선언 가능
	[public abstract] 반환자료형 메소드명([자료형 매개변수]);
	// public abstract가 생략되기 때문에
	// 오버라이딩 시 반드시 public 표기해야 함
}
```

* 특징

1. 모든 인터페이스의 메소드는 묵시적으로 public이고 abstract

2. 변수는 묵시적으로 public static final, 따라서 인터페이스 변수의 값 변경 시도 시 컴파일 시 에러 발생

3. 객체 생성은 안되나 참조형 변수로는 가능

* 장점

1. 상위 타입 역할로 다형성을 지원하여 연결

2. 해당 객체가 다양한 기능 제공 시에도 인터페이스에 해당하는 기능만을 사용하게 제한 가능

3. 공통 기능 상의 일관성 제공

4. 공동 작업을 위한 인터페이스 제공

### 추상클래스와 인터페이스

|구분|추상 클래스|인터페이스|
|:---:|:---:|:---:|
|상속|단일 상속|다중 상속|
|구현|extends 사용|implements 사용|
|추상 메소드|abstract 메소드 0개 이상|모든 메소드는 abstract|
|abstract|명시적 사용|묵시적으로 abstract|
|객체|객체 생성 불가|객체 생성 불가|
|용도|참조 타입|참조 타입|
