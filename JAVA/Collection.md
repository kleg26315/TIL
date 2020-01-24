# 컬렉션 (Collection)

메모리상에서 자료를 구조적으로 처리하는 방법을 `자료구조`라 일컫는데<br>
`컬렉션(Collection)`은 자바에서 제공하는 자료구조를 담당하는 프레임워크입니다.

추가, 삭제, 정렬 등의 기능처리가 간단하게 해결 되어 자료구조적 알고리즘을 구현할 필요가 없습니다.

java.util 패키지에 포함되어 있으며 인터페이스를 통해 정형화된 방법으로 다양한 컬렉션 클래스를 이용 가능합니다.


## 자료구조

데이터(자료)를 메모리에서 구조적으로 처리하는 방법론입니다.

![자료구조](https://github.com/kleg26315/TIL/blob/master/resources/%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0.PNG)



#### 배열의 문제점

1. 한 번 크기를 지정하면 변경할 수 없습니다.

```
필요에 따라 공간을 늘리거나 줄일 수 없고 공간 크기가 부족하면 에러가 발생합니다.
-> 할당 시 넉넉한 크기로 할당하게 됨 (메모리 낭비)
```

2. 기록된 데이터에 대한 중간 위치의 추가, 삭제가 불편합니다.

```
추가, 삭제할 데이터부터 마지막 기록된 데이터까지 하나씩 뒤로 밀어내고 추가해야 합니다. (복잡한 알고리즘)
```

3. 한 타입의 데이터만 저장 가능합니다.

#### 컬렉션의 장점

1. 저장하는 크기의 제약이 없습니다.

2. 추가, 삭제, 정렬 등의 기능 처리가 간단하게 해결됩니다.

```
자료를 구조적으로 처리 하는 자료구조가 내장되어 있어 알고리즘 구현이 필요 없습니다.
```

3. 여러 타입의 데이터가 저장 가능합니다. (하지만 제네릭을 지정해서 한 타입의 데이터만 많이 씀)

```
객체만 저장할 수 있기 때문에 필요에 따라 기본 자료형을 저장해야 하는 경우 Wrapper클래스를 사용합니다.
```

* 컬렉션의 주요 인터페이스

![컬렉션 인터페이스](https://github.com/kleg26315/TIL/blob/master/resources/%EC%BB%AC%EB%A0%89%EC%85%98%20%EC%9D%B8%ED%84%B0%ED%8E%98%EC%9D%B4%EC%8A%A4.PNG)

|인터페이스 분류|특징|구현 클래스|
|:---:|:---:|:---:|
|List 계열|- 순서를 유지하고 저장<br>- 중복 저장 가능|ArrayList, Vector, LinkedList|
|Set 계열|- 순서를 유지하지 않고 저장<br>- 중복 저장 안됨|HashSet, TreeSet|
|Map 계열|- 키와 값의 쌍으로 저장<br>- 키는 중복 저장 안됨<br>- 순서유지 안됨|HashMap, Hashtable,<br> TreeMap, Properties|

## List

자료들을 순차적으로 나열한 자료구조로 `인덱스`로 관리되며, 중복해서 객체 저장 가능합니다.<br>
구현 클래스로 `ArrayList`와 `Vector`, `LinkedList`가 있습니다.

* List 계열 주요 메소드

[실습 코드 확인하기](https://github.com/kleg26315/TIL/tree/master/CODE/JAVA/13_Collection/practice/list)

### ArrayList

List의 후손으로 초기 저장용량은 10으로 자동 설정되지만 따로 지정 가능합니다.<br>
저장 용량을 초과한 객체들이 들어오면 자동으로 증가되지만 고정도 가능합니다.<br>
`동기화(Synchronized)`를 제공하지 않습니다.

```
* 동기화 - 하나의 자원(데이터)에 대해 여러 스레드가 접근 하려 할 때 한 시점에서
하나의 스레드만 사용할 수 있도록 하는 것
```

예) List \<E> list = new ArrayList\<E>();

### Vector (ArrayList의 구버전)

List의 후손으로 ArrayList와 동등하지만 `동기화(Synchronized)`를 제공한다는 점이 ArrayList와의 차이점입니다.<br>
-> List 객체들 중에서 가장 성능이 좋지 않음

### LinkedList

List의 후손으로, 인접 참조를 링크해 체인처럼 관리합니다.<br>
특정 인덱스에서 객체를 제거하거나 추가하게 되면 바로 앞 / 뒤 링크만 변경하면 되기 때문에 객체 삭제와 삽입이 빈번하게<br>
일어나는 곳에선 **ArrayList보다 성능이 좋습니다.**

### Comparable, Comparator (인터페이스)

||Comparable|Comparator|
|:---:|:---:|:---:|
|패키지|java.lang|java.util|
|사용 메소드|compareTo()|compare()|
|정렬|기존의 정렬기준을 구현하는데 사용|그 외 다른 여러 기준으로 정렬하고자할 때 사
|사용법|정렬하고자 하는 객체에 Comparable를 상속받아<br>compareTo()메소드를 오버라이딩해 기존의 정렬<br>기준 재정의<br>-> **한 개의 정렬만 가능**|vo 패키지 안에 필요한 정렬 기준에 맞춘 클래스들을<br>생성하고 Comparator를 상속받아 compare()<br>메소드를 오버라이딩해 기존의 정렬 기준 재정의<br>-> **여러 개의 정렬 가능**|

* Collections.sort()

Collections.sort(List<T> list) -> T 객체의 **Comparable**을 상속받아 compareTo 메소드 재정의를 통해 정렬 구현 (한 개의 정렬)

Collections.sort(List<T> list, Comparator<T> c) -> 지정한 **Comparator**클래스에 의한 정렬 (여러 개의 정렬)

## Set

저장 순서가 유지되지 않고, 중복 객체도 저장하지 못하게 하는 자료 구조입니다.<br>
**null도 중복을 허용하지 않기 때문에 1개의 null만 저장**합니다.<br>
구현 클래스로 `HashSet`, `LinkedHashSet`, `TreeSet`이 있습니다.

* Set 계열 주요 메소드

[실습 코드 확인하기](https://github.com/kleg26315/TIL/tree/master/CODE/JAVA/13_Collection/practice/set)

### HashSet

Set에 객체를 저장할 때 hash함수를 사용하여 처리 속도가 빠릅니다.<br>
*동일 객체* 뿐 아니라 *동등 객체*도 중복하여 저장하지 않습니다.

* 동일 객체 : 변수는 다른데 주소값이 같은 객체

* 동등 객체 : 주소값은 다른데 데이터가 같은 객체

### LinkedHashSet

HashSet과 거의 동일하지만 Set에 추가되는 순서를 유지한다는 점이 다릅니다.

### TreeSet

검색 기능을 강화시킨 컬렉션으로, 계층 구조를 활용해 이진 트리 자료구조를 구현하여 제공합니다.<br>
이진 트리를 기반으로 한 Set 컬렉션으로, 왼쪽과 오른쪽 자식 노드를 참조하기 위한 두 개의 변수로 구성됩니다.

레드블랙트리 기반이기 때문에 데이터를 넣었을 때 자동으로 정렬이 됩니다.<br>
그래서 정렬기준이 꼭 필요하기에 Comparable 또는 Comparator를 통해 정렬 기준을 만들어줘야 합니다.

### Enumeration, Iterator, ListIterator

컬렉션에 저장된 요소를 접근하는데 사용되는 인터페이스로 set은 인덱스로 구성되어있지않아 요소를 가져올 때 사용합니다.

\- Iterator : 단방향이라는 특징, 1회성<br>
\- Enumeration : Iterator의 구버전<br>
\- ListIterator : Iterator를 상속받아 양방향 특징( next(), previous() ), List에서만 쓸 수 있음

Iterable은 Collection 상위 인터페이스이기 때문에 iterator() 메소드는 List와 Set 계열에서만 사용가능합니다.<br>
-> **Map의 경우 Set 또는 List화** 시켜서 iterator()를 사용해야 합니다.

## Map

키(key)와 값(value)으로 구성되어 있으며, 키와 값은 모두 객체입니다.<br>
키는 중복 저장을 허용하지 않고(`Set`방식), 값은 중복 저장 가능(`List`방식)합니다.<br>
키가 중복되는 경우, 기존에 있는 키에 해당하는 값을 덮어 씌웁니다.<br>
구현 클래스로는 `HashMap`, `Hashtable`, `LinkedHashMap`, `Properties`, `TreeMap`이 있습니다.

키와 값을 묶어놓고 있는 `Map.Entry`는 키와 값 그 자체를 나타냅니다.

Map안에 있는 Entry 안에는 키와 값을 불러오는 메소드들이 있습니다.

* Map 계열 주요 메소드

[실습 코드 확인하기](https://github.com/kleg26315/TIL/blob/master/CODE/JAVA/13_Collection/practice/map/controller/MapController.java)

### HashMap

키 객체는 `hashCode()`와 `equals()`를 재정의해 **동등 객체**가 될 조건을 정해야 합니다.<br>
그렇기 때문에, 키 타입은 hashCode와 equals() 메소드가 재정의 되어있는 `String타입`을 주로 사용합니다.

예) Map\<K, V> map = new HashMap\<K, V>();

### Hashtable (HashMap의 구버전)

키 객체 만드는 법은 HashMap과 동일하지만 Hashtable은 스레드 동기화가 된 상태이기 때문에,<br>
복수의 스레드가 동시에 Hashtable에 접근해 객체를 추가, 삭제 하더라도 스레드에 안전합니다.(Thread safe)

### Properties

**키와 값을 String타입으로 제한**한 Map컬렉션입니다.<br>
주로 Properties는 프로퍼티(*.properties)파일을 읽어 들일 때 주로 사용합니다.


### TreeMap

이진 트리를 기반으로 한 Map 컬렉션으로, 키와 값이 저장된 Map.Entry를 저장하고 왼쪽과 오른쪽 자식 노드를<br>
참조하기 위해 두 개의 변수로 구성됩니다.

