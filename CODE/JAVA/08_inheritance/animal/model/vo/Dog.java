package com.kh.example.animal.model.vo;

public class Dog extends Animal {
	// - name : String
	// - age : int
	// - weight : double
	// - height : double
	// - hair : String
	
	// + Dog()
	// + Dog(name:String, age:int, weight:double, height:double, hair:Stirng)
	
	// + getter/setter
	// + inform():String
	//		반환 형식 : 이름 나이 몸무게 키 털
	
	private double height;
	private String hair;
	
	public Dog() {}
	public Dog(String name, int age, double weight, double height, String hair) {
//		this.name = name;
//		this.age = age;
//		this.weight = weight;
		super(name, age, weight);
		this.height = height;
		this.hair = hair;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public String getHair() {
		return hair;
	}
	public void setHair(String hair) {
		this.hair = hair;
	}
	
//	public String inform() {
////		return super.getName()+" "+super.getAge()+" "+super.getWeight()+" "+height+" "+hair;
//		return super.inform()+" "+height+" "+hair;
//	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+" "+height+" "+hair;
	}
	
}
