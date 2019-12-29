자바에서 문자열을 비교하는 방법은 String클래스 안에 있는 equals를 이용하거나 == 을 이용하는 방법이 있습니다.
그렇다면 이 둘의 차이점은 무엇인지 알아보겠습니다.

## 1)형태의 차이
가장 단순한 차이점은 형태의 차이입니다.

equals()는 String클래스(boolean java.lang.String.equlas(Object object)) 안에 있는 equals() **메소드**를 이용합니다.
하지만 == 은 비교를 위한 **연산자**입니다.
 

## 2) 비교방식의 차이
간단한 예로, 서울에 사는 홍길동과 인천에 사는 홍길동
equals 메소드는 홍길도 자체의 값을 비교하는 것이고
==는 서울과 인천, 즉 주소값을 비교합니다.

equals 메소드는 비교하고자 하는 대상의 내용 자체를 비교하지만 == 연산자는 비교하자하는 대상의 주소값을 비교합니다.

이는 Call By Reference(이하 CBR), Call By Value(이하 CBV)에 대해 이해를 해야 하는 부분입니다.
CBV는 기본적으로 대상에 주소값을 가지지 않는 것으로 값을 할당받는 형태로 사용됩니다.
예를 들어 int, float, double, byte 등 primitive type(기본자료형)에 해당됩니다.

CBR은 대상을 선언했을 때, 주소값이 부여됩니다.
그래서 어떠한 객체를 불러왔을 때는 그 주소값을 불러온다고 봅니다.
이에는 Class, Object(객체)가 해당됩니다.

예를 들어, String 클래스를 이용해 문자열을 생성해보겠습니다.

String a = "aaa";

String b = a;

String c = new String("aaa");

a, b, c 모두 "aaa" 라는 내용을 가지고 있지만 주소값에 대해서는 다른 값을 가지는 변수가 존재합니다.
세 문자열이 주소값을 할당받는 내용을 그림으로 표현해보았습니다.
![설명](https://github.com/kleg26315/TIL/blob/master/resources/string-01.PNG)

회색 테두리가 문자열 변수 a, b, c를 표현한 내용입니다.
그림에서는 a, b, c 모두 같은 aaa라는 문자열 내용을 가지고 있지만,
a, b는 500이라는 임의의 주소값을 할당 받았으며, c는 600이라는 임의의 주소값을 할당받았습니다.

내용은 같지만 c가 다른 주소값을 할당받은 이유는 "aaa" 라는 문자열을 대입한 것이 아니라
new String("aaa") 를 통해 새로운 문자열을 선언하였기 때문입니다.

또한, String a = "aaa"; 방식과 String c = new String("aaa"); 의 정확한 차이점은

첫 번째는 문자열의 주소를 저장하는 방법이고 두 번째는 객체에 문자열을 넣고 객체의 주소를 저장하는 방법입니다.

## Reference
  * [https://kmj1107.tistory.com/entry](https://kmj1107.tistory.com/entry/JAVA-%EB%AC%B8%EC%9E%90%EC%97%B4string-%EB%B9%84%EA%B5%90-equals%EC%99%80-%EC%9D%98-%EC%B0%A8%EC%9D%B4%EC%A0%90-equals%EC%9D%98-%EB%B0%98%EB%8C%80)
  * https://wowon.tistory.com/130
