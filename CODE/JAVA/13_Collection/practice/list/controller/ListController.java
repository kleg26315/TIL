package com.kh.example.list.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.kh.example.list.model.compare.StudentComparator;
import com.kh.example.list.model.vo.Student;

public class ListController {
	public void doList() {
		List list1 = new ArrayList();
		// List is a raw type. References to generic type List<E> should be parameterized
		// 제네릭을 해주자
		
		List<Student> list = new ArrayList<Student>(3);	// 초기 저장용량은 10으로 자동 설정, 지정시 지정한 크기만큼 설정
		// add(E e) : 리스트 끝에 데이터 e 추가
		list.add(new Student("테스트",0));
		list.add(new Student("도대담",60));
		
		System.out.println("list : " + list);
		
		// 컬렉션 장점 1. 크기의 제약이 없다.
		list.add(new Student("남나눔", 90));
		list.add(new Student("하현호", 85));
		
		System.out.println("현재 list에 담긴 element 개수 : "+ list.size());
		System.out.println("list : " + list);

		// 컬렉션 장점 2. 추가/삭제/정렬 등의 기능처리 간단
		// add(int index, E e) : index번째 인덱스에 e 추가
		list.add(0, new Student("류라라",100));
		System.out.println("list : " + list);
		
		list.add(3, new Student("강건강",40));
		System.out.println("list : " + list);
		
		// remove(int index) : 해당 index번째 객체 삭제
		list.remove(1);
		System.out.println("list : " + list);
	
		// remove(Object o) : 해당 Object객체 삭제
		// Object 클래스 안에있는 equals()와 hashcode()를 둘다 오버라이딩해서 주소값을 
		// 비교하는 것이 아니라 안에 있는 필드값들을 비교하게 끔 재정의해야지만 new라고 해도 삭제가 가능하게한다.
		list.remove(new Student("강건강",40));
		System.out.println("list : " + list);
		
		// 정렬 방법 1. Collections 클래스 이용
		Collections.sort(list);			// 이름 순 정렬
		System.out.println("list : " + list);
		
		// 정렬 방법 2. List.sort()메소드 이용
		list.add(new Student("박보배", 85));
		list.sort(new StudentComparator());
		System.out.println("list : " + list);
		
		// set(int index, E e) : index번째 인덱스에 있는 요소를 e로 수정
		list.set(2, new Student("도대담", 31));
		System.out.println("list : " + list);
		
		// get(int index) : index번째 인덱스에 있는 요소를 가지고 옴
		Student s = list.get(2);
		System.out.println(s);
		System.out.println("list : " + list);
		
		// subList(int index1, int index2) : index1번째 인덱스부터 index2번째 인덱스까지 리스트 반환
		System.out.println("list 추출 : "+ list.subList(2, 5));
		
		// contains(Object o) : o가 리스트에 존재한다면 true 반환 
		// indexOf(Object o) : o가 리스트에 위치하는 인덱스 번호 반환, 없다면 -1 반환
		System.out.println("남나눔, 90이 있는가? "+ list.contains(new Student("남나눔",90)));
		System.out.println("남나눔, 90의 인덱스 위치는? "+ list.indexOf(new Student("남나눔",90)));
		System.out.println("테스트, 0의 인덱스 위치는? "+ list.indexOf(new Student("테스트",0)));
		
		// clear() : 저장된 모든 객체 삭제
		// isEmpty() : 리스트가 비었을 때 true 반환
		list.clear();
		System.out.println("list : "+ list);
		System.out.println("list가 비었나요? "+ list.isEmpty());
		
	}
}
