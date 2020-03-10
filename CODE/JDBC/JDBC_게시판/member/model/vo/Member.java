package com.kh.member.model.vo;

import java.sql.Date;

public class Member {
	private String memberId;
	private String memberPwd;
	private String memberName;
	private char gender;
	private String email;
	private String phone;
	private int age;
	private String address;
	private Date enrollDate;
	
	public Member() {}
	public Member(String memberId, String memberPwd, String memberName,
			char gender, String email, String phone, int age,
			String address, Date enrollDate) {
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberName = memberName;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.age = age;
		this.address = address;
		this.enrollDate = enrollDate;
	}
	
	public Member(String memberId, String memberPwd, String memberName,
			char gender, String email, String phone, int age,
			String address) {
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberName = memberName;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.age = age;
		this.address = address;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPwd() {
		return memberPwd;
	}
	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}
	
	@Override
	public String toString() {
		return memberId+", "+memberPwd+", "+memberName+", "+gender+", "+email+", "+phone+", "+address+", "+age+", "+enrollDate;
	}
}
