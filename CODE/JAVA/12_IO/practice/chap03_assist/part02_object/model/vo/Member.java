package com.kh.example.chap03_assist.part02_object.model.vo;

import java.io.Serializable;

public class Member implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2381941613205056360L;
	private String userId;
	private transient String userPwd;
	private String userName;
	private String email;
	private int age;
	private char gender;
	private double point;
	
	
	public Member() {}
	
	public Member(String userId, String userPwd, String userName, String email,
			int age, char gender, double point) {
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.email = email;
		this.age = age;
		this.gender = gender; 
		this.point = point;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserId() {
		return userId;
	}
	
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserPwd() {
		return userPwd;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public char getGender() {
		return gender;
	}
	public void setPoint(double point) {
		this.point = point;
	}
	public double getPoint() {
		return point; 
	}
	
	@Override
	public String toString() {
		return "Member [userId="+userId+", userPwd="+userPwd+", userName="+userName+", email="+email+", age="+age+", gender="+gender+", point="+point;
	}
}
