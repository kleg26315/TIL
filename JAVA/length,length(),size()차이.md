자바언어를 활용해 코딩을 하다보면 언제 어디서 length 와 length() 그리고 size() 를 쓰는지 자동완성 기능이 없다면 잘 모를때가 있습니다. 
그러므로 확실하게 이들의 차이점을 알아보도록 하겠습니다.

## 1. length

* arrays(int[], double[], String[])
* length는 **배열의 길이**를 알고자 할때 사용됩니다.

## 2. length()

* String related Object(String, StringBuilder etc)
* length()는 **문자열의 길이**를 알고자 할때 사용됩니다.

## 3. size()

* Collection Object(ArrayList, Set etc)
* size()는 **컬렉션프레임워크 타입의 길이**를 알고자 할때 사용됩니다.



### Example
```java
public class lengthSizeTest{
	public static void main(String[] args){
		int[] lengthTest1 = new int[7];
		System.out.println(lengthTest1.length); // 7

		String lengthTest2 = "lengthSizeTest";
		System.out.println(lengthTest2.length()); // 14

		ArrayList<Object> sizeTest = new ArrayList<Object>();
		System.out.println(sizeTest.size()); // 0
	}
}
```
