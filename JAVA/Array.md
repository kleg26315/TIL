배열이란 **같은 자료형**의 변수를 하나의 묶음으로 다루는 것입니다.
배열은 저장된 값마다 인덱스 번호가 0부터(제로기반인덱스) 시작하여 설정합니다.

배열 선언 : 자료형[] 배열명; , 자료형 배열명[];

배열 할당 : 자료형[] 배열명 = new 자료형[배열크기];
ex) int[] arr = new int[3];

**new 연산자**는 Heap영역에 공간을 생성하고(주소값이 생김) 변수와 배열은 stack영역에 생성됩니다.
* [code 확인하러가기](https://github.com/kleg26315/TIL/blob/master/CODE/JAVA/04_array/A_Array.java)

## 배열 저장구조
![배열선언할당](https://github.com/kleg26315/TIL/blob/master/resources/%EB%B0%B0%EC%97%B4%EC%84%A0%EC%96%B8%ED%95%A0%EB%8B%B9.PNG)

선언했던 arr이라는 배열은 stack영역에 생성되고 new 연산자로 주소값이 생성되고
대입 연산자(=)를 통해 Heap영역에 생성된 주소값을 arr배열에 대입하기때문에 Stack영역에 arr배열의 주소값은 Heap영역에
주소값을 참조합니다.

정리하자면, 배열은 참조 변수로 Heap 영역에 할당되며 배열 공간의 주소를 저장하고 배열 공간의 주소를 이용해 인덱스를
참조하는 방식으로 값을 처리합니다.

cf) C언어는 주소값을 확인하고 변경가능하지만 자바는 주소값을 확인할 수 없습니다.

## 배열의 크기 변경
![배열크기변경](https://github.com/kleg26315/TIL/blob/master/resources/%EB%B0%B0%EC%97%B4%ED%81%AC%EA%B8%B0%EB%B3%80%EA%B2%BD.jpg)

배열의 크기를 이처럼 변경할 시 기존 힙영역에 생성되었던 크기의 주소값이 변경되는 것이 아닌
힙영역에 새로운 주소값을 가진 공간이 만들어지고 참조하는 주소값이 달라지는 것이다.
참조가 끊어진(이전에 사용되었던) 공간은 Old 영역으로 이동하게 되며 GC에 의해 사라집니다.

배열이 힙영역의 주소값 참조를 모두 끊고 싶을 땐 arr = null; 널값을 주며 할당을 없앨 수 있습니다.

## 배열 복사
얕은 복사 : 객체의 주소 값만 가져와 참조형 변수에 저장하고 하나의 객체를 두 변수가 참조하는 것
![얕은복사](https://github.com/kleg26315/TIL/blob/master/resources/%EC%96%95%EC%9D%80%EB%B3%B5%EC%82%AC.PNG)
```java
int[] arr1 = new int[4];
int[] arr2 = arr1;
```

깊은 복사 : 안에 담긴 데이터가 같은거지 담긴 공간의 주소값은 다름
![깊은복사](https://github.com/kleg26315/TIL/blob/master/resources/%EA%B9%8A%EC%9D%80%EB%B3%B5%EC%82%AC.PNG)
```java
for(int i=0; i<arr1.length; i++){
	arr2[i] = arr1[i];
}
```
```java
System.arraycopy(arr1, 0, arr2, 0, arr1.length);
```
```java
arr2 = Arrays.copyOf(arr1, arr1.length);
```
```java
arr2 = arr1.clone(0);
```

* [code 확인하러가기](https://github.com/kleg26315/TIL/blob/master/CODE/JAVA/04_array/B_ArrayCopy.java)
