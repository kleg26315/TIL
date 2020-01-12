package com.kh.example.chap02_abstractInterface.family.model.vo;

public class Baby extends Family implements Basic{
	
	public Baby() {}
	public Baby(String name, double weight, int health) {
		super(name, weight, health);
	}
	@Override
	public String toString() {
		return "Baby ["+super.toString() + "]";
	}
	
	@Override
	public void eat() {
		super.setWeight(super.getWeight() + 3);
		super.setHealth(super.getHealth() + 1);
		
	}
	@Override
	public void sleep() {
		super.setHealth(super.getHealth() +1 );
	}
}
