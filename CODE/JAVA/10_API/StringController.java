package com.kh.example.chap01_String.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class StringController {
	public void method1() {
		String str1 = "java";
		String str2 = str1;
		String str3 = new String("java");
		
		
		System.out.println("str1과 str2의 주소는 같은가? : "+(str1 == str2));	// true
		System.out.println("str1과 str3의 주소는 같은가? : "+(str1 == str3));	// false
		
		System.out.println("str1의 hashCode : "+str1.hashCode());		// 3254818
		System.out.println("str2의 hashCode : "+str2.hashCode());		// 3254818
		System.out.println("str3의 hashCode : "+str3.hashCode());		// 3254818
		
		System.out.println("str1의 실주소값 : "+System.identityHashCode(str1));	// 366712642
		System.out.println("str2의 실주소값 : "+System.identityHashCode(str2));	// 366712642
		System.out.println("str3의 실주소값 : "+System.identityHashCode(str3));	// 1829164700
		
		str2 += "oracle";
		System.out.println("str1과 str2의 주소는 같은가? : "+(str1==str2));		// false
		System.out.println("str1의 실주소값 : "+System.identityHashCode(str1));	// 366712642
		System.out.println("str2의 실주소값 : "+System.identityHashCode(str2));	// 2018699554
		System.out.println("str3의 실주소값 : "+System.identityHashCode(str3));	// 1829164700
	}
	
	public void method2() {
		// StringBuffer Test
		// 계속해서 값을 변경해야할 때 String같은 경우 불변이라는 특징 때문에 값이 새로 생기고 참조 위치만 바꿔주기 때문에
		// 가비지 컬렉터가 계속 지워야하는 단점이 있음
		// 변경이 적고 읽기만 하는 경우에는 불변 클래스인 String 클래스가 용이하겠지만
		// 변경해야하는 값이 많은 경우 StringBuffer나 StringBuilder로 하는게 더 효율적임
		
		StringBuffer buffer1 = new StringBuffer();
		System.out.println("초기 buffer1의 수용량 : "+ buffer1.capacity());	// 16
		System.out.println("buffer1에 들어있는 실제 값의 길이 : "+buffer1.length()); // 0
		
		System.out.println();
		
		StringBuffer buffer2 = new StringBuffer(100);	
		System.out.println("초기 buffer2의 수용량 : "+buffer2.capacity());	// 100
		System.out.println("buffer2에 들어있는 실제 값의 길이 : "+buffer2.length());	// 0
		
		System.out.println();
		
		StringBuffer buffer3 = new StringBuffer("abc");
		System.out.println("초기 buffer3의 수용량 : "+buffer3.capacity());	// 19
		System.out.println("buffer3에 들어있는 실제 값의 길이 : "+buffer3.length());	// 3
		
		System.out.println();
		
		StringBuilder builder = new StringBuilder("abc");
		System.out.println("초기 builder의 수용량 : "+builder.capacity());	// 19
		System.out.println("builder에 들어있는 실제 값의 길이 : "+builder.length()); // 3
		
		System.out.println();
		
		builder.append("abc").append("def"); // 메소드 체이닝
		System.out.println("abc, def 추가 후의 builder : "+builder);	// abcabcdef
		System.out.println("abc, def 추가 후의 builder 용량 : "+builder.capacity());	// 19
		System.out.println("abc, def 추가 후의 builder 길이 : "+builder.length());	// 9

		System.out.println();
		
		builder.insert(2, "zzz");	
		System.out.println("인덱스2에 zzz 추가 후의 builder : "+builder);	// abzzzcabcdef
		
		System.out.println();

		builder.delete(2, 5); // start <= 인덱스 < end
		System.out.println("인덱스 2부터 5까지 삭제 후의  builder : "+builder);	// abcabcdef

		System.out.println();
		
		builder.reverse();
		System.out.println("reverse 후의  builder : "+builder);	// fedcbacba
		
		StringBuilder sb = new StringBuilder("abc");
		sb = sb.append("zzz").insert(2, "yy").reverse().delete(1, 3);	
		
		System.out.println(sb); // zcyyba
	}
	
	public void method3() {
		String str = "Hello World";
		
		// 1. charAt(int index):char
		//    String의 index번째 char 반환
		char ch = str.charAt(4);	// o
		System.out.println(ch);
		
		// 2. concat(String str):String
		//    매개변수로 들어온 값을 원래 String의 끝에 이어붙인 값(String)을 반환
		String concatStr = str.concat("!!!");
		System.out.println("concatStr : "+concatStr);	// Hello World!!!
		
		str += "!!!";
		System.out.println(str);	// Hello World!!!
		
		// 3. equals():boolean
		System.out.println("concat.equals(str) : "+concatStr.equals(str)); // true
		
		// 4. substring(int beginIndex):String
		//    substring(int beginIndex, int endIndex):String
		//    String의 일부를 반환 - 매개변수가 하나면, 그 인덱스부터 끝까지 반환
		//                    - 매개변수가 두개면, 시작 인데스 <= 문자 < 끝 인덱스
		System.out.println("str.substring(6) : "+str.substring(6));	// World!!!
		System.out.println("str.substring(0, 5) : "+str.substring(0, 5)); // Hello
		
		// 5. replace(char oldChar, char newChar):String
		//    지정 char를 새로운 char로 대체하여 반환
		System.out.println("str.replace('l','e') : "+ str.replace('l', 'e'));	// Heeeo Wored!!!
		
		// 6. toUpperCase()/toLowerCase():String
		//    모든 대문자 혹은 소문자로 바꿔 반환
		System.out.println("str.toUpperCase() : "+ str.toUpperCase());	// HELLO WORLD!!!
		System.out.println("str.toLowerCase() : "+ str.toLowerCase());	// hello world!!!
	
		// 7. equalsIgnoreCase():boolean
		String str2 = "Wonderful";
		String str3 = "wonderful";
		System.out.println("str2.equals(str3) : "+ str2.equals(str3));	// false
		System.out.println("str2.equalsIgnoreCase(str3) : "+ str2.equalsIgnoreCase(str3));	// true
		
		// 8. trim():String
		//    *앞/뒤*에 있는 공백(빈 공간)을 제거한 문자열 반환
		String str4 = "    Java";
		String str5 = "Java    ";
		String str6 = "    Java    ";
		System.out.println(str4+"| str4.trim() : "+str4.trim());	//     Java| str4.trim() : Java 
		System.out.println(str5+"| str5.trim() : "+str5.trim());	// Java    | str5.trim() : Java
		System.out.println(str6+"| str6.trim() : "+str6.trim());	//     Java    | str6.trim() : Java
		
		// 9. split(String str):String[]
		//    문자열을 분리하여 배열에 담아 반환
		String splitStr = "Java, Oracle, JDBC, Front, Server, Framework";
		String[] splitArr = splitStr.split(", ");
		System.out.println("분리된 문자열 개수(split) : "+splitArr.length);	// 분리된 문자열 개수(split) : 6
		
		for(int i=0; i<splitArr.length; i++) {
			System.out.println(splitArr[i]);
		}
		
		// 향상된 for문(for-each문)/
		for(String s : splitArr) {
			System.out.println(s);
		}
		
		// 9-2. StringBuilder로 split을 응용할 때
		StringBuilder splitStr2 = new StringBuilder("Java, Oracle, JDBC, Front, Server, Framework");

		String[] temp = splitStr2.toString().split(", ");
	
		StringBuilder[] splitArr2 = new StringBuilder[temp.length];
		for(int i = 0; i < splitArr2.length; i++) {
			splitArr2[i] = new StringBuilder();
		}
		for(int i=0; i<temp.length; i++) {
			splitArr2[i].append(temp[i]);
		}
		for(int i=0; i<splitArr2.length; i++) {
			System.out.println(splitArr2[i]);
		}
	}
	
	public void method4() {
		String str = "Java, Oracle, JDBC, Front, Server, Framework";
		StringTokenizer stObj = new StringTokenizer(str,", ");
		System.out.println("분리된 문자열 개수 : "+ stObj.countTokens());
		
		while(stObj.hasMoreTokens()) {
			System.out.println(stObj.nextToken());
		}
		System.out.println("값을 꺼낸 후의 문자열 개수 : "+stObj.countTokens());
		
		System.out.println();
		
		String str2 = "Apple,Banana-Cream-Dessert#Egg Fruits";
		StringTokenizer stObj2 = new StringTokenizer(str2,", -*#");
		System.out.println("분리된 문자열 개수 : "+stObj2.countTokens());
		
		while(stObj2.hasMoreTokens()) {
			System.out.println(stObj2.nextToken());
		}
		
		// split()과 StringTokenizer의 차이점
		// 1. 분리한 문자열을 String[]로 처리하고 싶을 때 split() 메소드
		//    분리한 문자열을 객체로 처리하고 싶을 때 StringTokenizer클래스
		// 2. split()메소드의 구분자는 1개
		//    StringTokenizer클래스의 구분자는 여러 개
	}
}
