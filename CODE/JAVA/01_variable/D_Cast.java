package com.kh.variable;

public class D_Cast {
	public void rule1() {
		boolean flag = true;
//		boolean flag2 = 100;
		//boolean 자료형은 무조건 true, false만 들어갈 수 있음 (형변환 예외)
		
		int num = 'A';
		System.out.println("num : "+num);
		
		char ch = 97;
		System.out.println("ch : "+ch);
		
		char ch2 = (char)num;
		System.out.println("ch2 : "+ch2);
		// Type mismatch: cannot convert from int to char
		// : 리터럴을 넣을 땐 그냥 알아서 되는데 이렇게 변수를 넣게되면 그 변수의 자료형을 보기 때문에 4바이트가 2바이트 char로 
		//   들어갈 수 없기때문에 강제 형변환이 필요하다
		
		int num2 = -97;
		char ch3 = (char) num2;
		System.out.println("ch3 : "+ ch3);
		// 여기서 결과값이 ? 가 뜨는건 찾을 수 없어서 ?가 뜨는거지 ?에 맞는 유니코드가 맞춰서 나오는 결과값이 아니다.	
	}
	
	public void rule2() {
		int iNum = 10;
		long lNum = 100;
		
//		int result = iNum + lNum;
		// Type mismatch: cannot convert from long to int
		// : 연산은 큰 자료형으로 자동 형변환이 된 후 연산처리가 되기 때문에 iNum + lNum의 결과는 long형이 된 상태
		//   이 상태에서 result 타입 int로 넣으려고 하기 때문에 강제 형변환이 필요함
		
		// iNum + lNum을 int result에 저장할 수 있는 방법
		// 방법 1. 수행 결과를 int로 강제 형변환
		int result = (int) (iNum + lNum);
		
		// 방법 2. long형 lNum을 int로 강제 형변환
		int result2 = iNum +(int)lNum;
		
		// 번외. 결과 값을 저장하는 result를 long형으로 변경
		long result3 = iNum + lNum;
		
	}
	
	public void rule3() {
		int iNum = 290;
		
		byte bNum = (byte) iNum;
		
		System.out.println("bNum : "+bNum);
		// ★Overflow가 아닌 데이터 손실이 일어나서 290이 아니라 34가 출력된다.
		
	}
}
