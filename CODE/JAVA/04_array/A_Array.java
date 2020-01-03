package com.kh.example.array;

import java.util.Scanner;

public class A_Array {
	// 배열 : 같은 자료형의 변수를 하나의 묶음으로 다루는 것
	
	// 배열 선언
	// 		자료형[] 배열명;
	//		자료형 배열명[];
	// 배열 할당
	//		자료형[] 배열명 = new 자료형[배열크기];
	//		자료형 배열명[] = new 자료형[배열크기];
	//		new연산자를 통해 Heap영역에 배열크기만큼 공간 생성
	//		공간이 생성되는 순간 그 공간에 대한 주소값이 생김
	//		그 주소 값은 Stack에 있는 배열명 공간에 대입(참조하고 있음)
	
	// 배열 초기화
	//		1) 인덱스 이용
	//			배열명[인덱스번호] = 값;
	//		2) for문 이용 : 규칙이 있을 때만 사용 가능
	//			for(int i = 0; i < 배열명.length; i++){
	//				배열명[i] = 값;
	//			}
	//		3) 선언과 동시에 초기화
	//			자료형[] 배열명 = {값};
	//			자료형[] 배열명 = new 자료형[]{값};

	public void method1() {
		int[] arr = new int[9];
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		arr[3] = 40;
		arr[4] = 50;
		arr[5] = 60;
		arr[6] = 70;
		arr[7] = 80;
		arr[8] = 90;
//		arr[9] = 100;	// java.lang.ArrayIndexOutOfBoundsException: 9
		
		for(int i =0; i< arr.length; i++) {
			arr[i] = (i+1) * 10;
		}
		
		int sum = 0;
		for(int i =0; i<arr.length; i++) {
			sum += arr[i];
		}
		
		for(int i =0; i<arr.length; i++) {
			System.out.println("arr["+i+"] : "+arr[i]);
		}
		System.out.println("sum : "+sum);
		
	}
	
	public void method2() {
		// 배열은 한 번 지정한 배열의 크기를 변경할 수 없음
		double[] dArr = new double[10];
		System.out.println("dArr의 주소 : "+dArr);
		
		Scanner sc = new Scanner(System.in);
		System.out.print("변경할 배열 크기 : ");
		int size = sc.nextInt();
		
		dArr = new double[size];
		System.out.println("dArr의 주소 : "+dArr);
		dArr = null;
		System.out.println("dArr의 주소 : "+dArr);
	}
	
	public void method3() {
		// 배열 초기화
		// 1. 인덱스 이용
		// iArr이라는 int형 5개짜리 배열 생성
		int[] iArr = new int[5];
		iArr[0] = 1;
		iArr[1] = 2;
		iArr[2] = 3;
		iArr[3] = 4;
		iArr[4] = 5;
		
		// 2. for문 초기화
		for(int i = 0; i<iArr.length; i++) {
			iArr[i]= i +1;
		}
		// 3. 선언과 동시에 초기화
		int[] iArr2 = {1,2,3,4,5};
		int[] iArr3 = new int[] {1,2,3,4,5};
	}
	
}
