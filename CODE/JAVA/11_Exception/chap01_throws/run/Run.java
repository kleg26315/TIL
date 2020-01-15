package com.kh.example.chap01_throws.run;

import com.kh.example.chap01_throws.controller.ThrowsController;

public class Run {
	public static void main(String[] args) /* throws Exception */ {
		// 메인 메소드에서도 예외 상황을 호출한 쪽(JVM)으로 위임할 수 있음 ==> 비정상 종료
		ThrowsController tc= new ThrowsController();
		
		try {
			tc.method1();
		} catch (Exception e) {
			e.printStackTrace();  // 예외 내용과 예외 발생 위치를 콘솔에 출력해주는 메소드
//			System.out.println("예외 상황이 발생하였습니다.");
		}
		
		System.out.println("정상적으로 종료 됨...");
	}
}
