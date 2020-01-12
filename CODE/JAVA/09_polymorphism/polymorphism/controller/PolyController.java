package com.kh.example.chap01_poly.test.controller;

import com.kh.example.chap01_poly.test.model.vo.Child1;
import com.kh.example.chap01_poly.test.model.vo.Child2;
import com.kh.example.chap01_poly.test.model.vo.Parent;

public class PolyController {

	public void method() {
		System.out.println("1. 부모타입 레퍼런스로 부모 객체를 다루는 경우");
		Parent p = new Parent();
		// ㄴ부모타입 레퍼런스       ㄴ 부모 객체
		p.printParent();		// 출력 : 나 부모야
		
		System.out.println("2. 자식타입 레퍼런스로 자식 객체를 다루는 경우");
		Child1 c1 = new Child1();
		// ㄴ자식타입 레퍼런스         ㄴ 자식 객체
		c1.printChild1();		// 출력 : 나 첫 번째 자식이야
		c1.printParent();		// 출력 : 나 부모야
		
		System.out.println("3. 부모타입 레퍼런스로 자식 객체를 다루는 경우");
		Parent p2 = new Child2();	// 다형성(업캐스팅 : 부모타입의 참조형 변수가 모든 자식 객체를 받을 수 있는 것)
		p2.printParent();			// Parent 메소드만 확인 가능함
		((Child2)p2).printChild2(); // (다운캐스팅 : 부모타입의 참조형 변수가 자식의 멤버를 참조해야할 경우, 형변환을 통해 Child2 메소드까지 확인 가능함)
		
		System.out.println("4. 자식타입 레퍼런스로 부모 객체를 다루는 경우");
//		Child2 c2 = new Parent();	// 부모는 자식을 받을 수 있지만 자식은 부모를 받을 수 없다.
		// Type mismatch: cannot convert from Parent to Child2
		// 3번은 parent가 보는 것이  child2로 생성된 자기자신과 parent를 포함하여 가지고 있기때문에 이미 가지고있는것에서 달라는 것이기때문에 에러가 나지 않지만
		// 이 경우는 child2가 보는 것이 parent로 생성된 parent 밖에 없기때문에 에러가 남
		
		System.out.println();
		System.out.println("=== 간단 에제 ===");
		System.out.println();
		
		Parent[] pArr = new Parent[4];
		pArr[0] = new Child1();
		pArr[1] = new Child2();
		pArr[2] = new Child1();
		pArr[3] = new Child2();
		
		for(int i =0; i< pArr.length; i++) {
			if(pArr[i] instanceof Child1) {
				((Child1)pArr[i]).printChild1();
			} else if (pArr[i] instanceof Child2) {
				((Child2)pArr[i]).printChild2();
			}
		}
		
		for(int i =0; i<pArr.length; i++) {
			pArr[i].print();
		}
	}

}
