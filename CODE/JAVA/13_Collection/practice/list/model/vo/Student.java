package com.kh.example.list.model.vo;

public class Student implements Comparable<Student> {
	private String name;
	private int score;
	
	public Student() {}
	
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getScore() {
		return score;
	}
	
	@Override
	public String toString() {
		return name+"("+score+"점)";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31; // 31은 컴퓨터가 인지했을 때 계산하기 좋으면서 적당히 큰 소수입니다.
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());	// 참조형 변수일 땐 이렇게 삼항연산자를 이용하고
		result = prime * result + score;									// 기본형 자료형일 땐 이렇게 그냥 더하면 됨
		
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		/* 객체 자체를 비교한 부분 */
		if(this == obj) { // this란 내 주소값을 담고 있는 레퍼런스 변수
			return true;	// 매개변수로 들어온 객체의 주소값과 내 주소값과 같으면 같은 변수인 것임
		}
		if(obj == null) {
			return false;	// 들어온 객체가 null이면 나와 같을 리가 없으니 false
		}
		if(getClass() != obj.getClass()) {	// getClass() : 내 클래스에 대한 정보를 담고 있는 메소드
			return false;
		}
		
		/* 필드에 대해서 비교 */
		Student other = (Student)obj;
		if(name == null) {				// 참조형 변수일 땐 이렇게 먼저 null이 아닌지부터 검사해야함
			if(other.name != null) {	// 내가 가지고 있는 name이 null일때 가져온 name이 null이 아니면 다르다
				return false;
			}
		} else if(!name.equals(other.name)) {	// 내가 가지고 있는 null이 아니면서 가져온 name이랑 같지 않으면 다르다
			return false;
		}
		
		if(score != other.score) {		// 기본형 자료형일땐 이렇게 비교만 하면 됨
			return false;
		}
		
		return true;
	}

	@Override
	public int compareTo(Student o) {
		// 이름에 대해서 오름차순 정렬
		// 이름 ==> String
		// ==> String에 대해 오름차순 정렬
		
		String othername = o.getName();
		
		/*
			compareTo의 반환 값 : int
			비교 주체가 비교 대상과 같으면 0 반환
			비교 주체가 비교 대상보다 크면 1 반환
			비교 주체가 비교 대상보다 작으면 -1 반환
		 */
		
		return name.compareTo(othername);	// 내림차순할 시에는 앞에 -를 붙히면 됨
	}
}
