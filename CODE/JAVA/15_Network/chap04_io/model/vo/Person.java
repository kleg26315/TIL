package com.kh.example.chap04_io.model.vo;

import java.io.Serializable;

public class Person implements Serializable{

	private static final long serialVersionUID = -3591532140703328614L;
	
	private String name;
	private int age;
	public Person() {}
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return name + "("+age+")";
	}
}
