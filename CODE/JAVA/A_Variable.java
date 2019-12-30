package com.kh.variable;

public class A_Variable { // 클래스
	
	public void declareVariable	() { // 메소드
		// 변수 선언 후 초기화
		// A. 변수선언 : 자료형 변수명;
		// 1. 논리형
		boolean isTrue;
		// 2. 문자형
		// 2-1. 문자
		char ch;
		// 2-2. 문자열
		String str;
		// 3. 숫자형
		// 3-1. 정수
		byte bnum;
		short snum;
		int inum;
		long lnum;
	
		// 3-2. 실수
		float fnum;
		double dnum;
		
		// B. 초기화(대입) : 변수명 = 값;
		isTrue = true;
		bnum = 1;
		snum = 2;
		inum = 4;
		lnum = 8L;
		
		//fnum = 4.0;
		// Type mismatch: cannot convert from double to float
		// : 4.0은 실수인데 기본적으로 실수는 double이 기본형이기 때문에
		//   4.0을 float가 아닌 double로 보고 있음
		//   근데 fnum은 자료형이 float(4byte)인데 넣고자하는 값은 8byte인 double형이기 때문에
		//   큰 값을 작은 공간에 집어넣을 수 없다면서 에러가 떴음
		fnum = 4.0f;
		dnum = 8.0;
		
		ch = 'A';
		str = "ABCD";
		
		System.out.println("isTrue의 값 : " + isTrue);
		System.out.println("bnum의 값 : "+bnum);
		System.out.println("snum의 값 : "+snum);
		System.out.println("inum의 값 : "+inum);
		System.out.println("lnum의 값 : "+lnum);
		System.out.println("fnum의 값 : "+fnum);
		System.out.println("dnum의 값 : "+dnum);
		System.out.println("ch의 값 : "+ch);
		System.out.println("str의 값 : "+str);
	}
	
	public void initVariable() {
		// 변수 선언과 동시에 초기화
		// 1. 논리형
		boolean isTrue = false;
		// 2. 문자형
		char ch = '가';
		String str = "가나다라";
		// 3. 숫자형
		// 3-1. 정수
		byte bnum = 1;
		short snum = 2;
		int inum = 4;
		long lnum = 8L;
		// 3-2. 실수
		float fnum = 4.0f;
		double dnum = 8.0d;
		
		System.out.println("isTrue의 값 : " + isTrue);
		System.out.println("bnum의 값 : " + bnum);
		System.out.println("snum의 값 : " + snum);
		System.out.println("inum의 값 : " + inum);
		System.out.println("lnum의 값 : "+ lnum);
		System.out.println("fnum의 값: " + fnum);
		System.out.println("dnum의 값: "+ dnum);
		System.out.println("ch의 값 : " + ch);
		System.out.println("str의 값 : "+ str);
	}
	/*
	public static void main(String[] args) {
		declareVariable();
		// static이 있는 메소드에서 다른 메소드를 불러올때는 그 불러와지는 메소드도 static 메소드여야만한다.
		// 이 메소드가 main이 아니여도 static메소드 에서 다른 메소드를 불러올때 그 메소드도 static이여야함
	}
	*/
}
