## 기본 API

기본적으로 자주 사용하게되는

String 관련, Wrapper 관련, 날짜 관련, Format 관련 클래스들을 순서대로 정리해보겠습니다.

참고) 참조형 자료형은 전부 클래스입니다.

### String 클래스

문자열 값 수정 불가능, immutable(불변)입니다.
수정 시 수정된 문자열이 새로이 할당 되어 새 주소를 넘깁니다.

[String 메소드들(method3)](https://github.com/kleg26315/TIL/blob/master/CODE/JAVA/10_API/StringController.java)

### StringBuffer 클래스
String과 다르게 문자열 값 수정가능(mutable:가변)합니다. 수정, 삭제 등이 기존 문자열에 수정되어 적용됩니다.

기본 16문자 크기로 지정된 버퍼를 이용하며 크기 증가가 가능합니다. 또한 쓰레드 safe기능을 제공하여 성능이 저하되는 요인이 됩니다.

### StringBuilder 클래스

StringBuffer와 동일하나 쓰레드 safe기능을 제공하지 않습니다.

이러한 특징때문에 계속해서 값을 변경해야할 때 String같은 경우 불변이라는 특징 때문에 값이 새로 생기고 참조 위치만 바꿔주기 때문에
가비지 컬렉터가 계속 지워야하는 단점이 있습니다. 그래서 변경이 적고 읽기만 하는 경우에는 불변 클래스인 String 클래스가 용이하겠지만
변경해야하는 값이 많은 경우 StringBuffer나 StringBuilder로 하는게 더 효율적입니다.

[StringBuilder, StringBuffer 메소드들(method2)](https://github.com/kleg26315/TIL/blob/master/CODE/JAVA/10_API/StringController.java)

--------------------------------------------------------------------
### Wrapper 클래스

Primitive Data Type을 객체화 해주는 클래스

기본자료형을 객체화하는 것을 박싱이라고 합니다.
반대로, 객체를 기본자료형으로 바꾸는 것을 언박싱이라고 합니다.

* String을 기본 자료형으로 바꾸기

byte b = Byte.parseByte("1");
...
double d = Double.parseDouble("0.2");
boolean bool = Boolean.parseBoolean("true");
char c = "abc".charAt(0);

char 자료형만 parse형식이 아니고 boolean 언박싱은 오직 "true", "false"만 됩니다.

* 기본 자료형을 String으로 바꾸기

String b = Byte.valueOf((byte)1).toString();
String s = Short.valueOf((short)2).toString();
String i = Integer.valueOf(3).toString();
...
String bool = Boolean.valueOf(true).toString();
String ch = Character.valueOf('a').toString();

String i2 = String.valueOf(10); 도 가능합니다.

--------------------------------------------------------------------
### 날짜 관련 클래스

[실습코드](https://github.com/kleg26315/TIL/blob/master/CODE/JAVA/10_API/DateController.java)

* Date 클래스

시스템으로부터 현재 날짜, 시간 정보를 가져와서 다룰 수 있게 만들어진 클래스입니다.

생성자 2개만 사용 가능하고 나머지는 모두 deprecated 입니다.

deprecated 됐기 때문에 Calendar 클래스 혹은 GregorianCalendar 클래스를 사용 권장합니다.

(Deprecated : 더 이상 사용되지 않음)

* Calendar 클래스

Calendar클래스는 생성자가 protected이기 때문에 new 연산자를 통해서 객체 생성 불가능합니다.

그래서 Calendar 클래스 객체를 생성할 땐 getInstance() 메소드를 통해서 객체를 생성합니다.

* GregorianCalendar 클래스

GregorianCalendar 클래스는 Calendar 클래스의 후손 클래스입니다.

년, 월, 일, 시, 분, 초 정보를 필드를 이용하여 다룰 수 있습니다.

### Format 관련 클래스

* SimpleDateFormat 클래스

Date의 날짜, 시간 정보를 원하는 format으로 출력하는 기능을 제공합니다. (java.text 패키지에 속해있음)

```java
Date today = new Date();

SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");

String ftToday = ft.format(today);
// today에 포맷을 적용한 결과를 문자열로 리턴
```

