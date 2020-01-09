package com.kh.example.animal.model.vo;

public class Snake extends Animal{
	// - name : String
	// - age : int
	// - weight : double
	// - pattern : String
		
	// + Snake()
	// + Snake(name:String, age:int, weight:double, pattern:Stirng)
		
	// + getter/setter
	// + inform():String
	//		반환 형식 : 이름 나이 몸무게 무늬
	
	private String pattern;
	
	public Snake() {}
	public Snake(String name, int age, double weight, String pattern) {
//		this.name = name;
//		this.age = age;
//		this.weight = weight;
		super(name,age,weight);
		this.pattern = pattern;
	}
	public String getPattern() {
		return pattern;
	}
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	
//	public String inform() {
//		return super.inform()+" "+pattern;
//	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+" "+pattern;
	}
}
