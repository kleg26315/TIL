package com.kh.hw.member.controller;

import com.kh.hw.member.model.vo.Member;

public class MemberController {
	private Member[] m = new Member[SIZE];
	public static final int SIZE = 10;
	
	public int exitsMemberNum() {
		int cnt =0;
		if(m==null) {
			
		}
		else{
			for(int i=0; i<m.length; i++) {
				if(m[i]!=null){
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	public Boolean checkId(String inputId) {
		boolean check = false;
		for(int i =0; i<m.length; i++) {
			if(m[i]!=null) {
				if(m[i].getId().equals(inputId)) {
					check = true;
					break;
				}	
			}
		}
		return check;
	}
	
	public void insertMember(String id, String name, String password, 
			String email, char gender, int age) {
		for(int i=0; i<m.length; i++) {
			if(m[i] == null) {
				m[i] = new Member(id,name,password,email,gender,age);
				break;
			}
		}
	}
	
	public String searchId(String id) {
		String result = "";
		for(int i=0; i<m.length; i++) {
			if(m[i]!=null) {
				if(m[i].getId().equals(id)) {
					result = m[i].inform();
					break;
				}
			}
		}
		return result;
	}
	
	public Member[] searchName(String name) {
		Member[] m2 = new Member[SIZE];
		int cnt = 0;
		for(int i=0; i<m.length; i++) {
			if(m[i]!=null) {
				if(name.equals(m[i].getName())) {
					m2[cnt] = m[i];
					cnt++;
				}
			}
		}
		return m2;
	}
	
	public Member[] searchEmail(String email) {
		Member[] m2 = new Member[SIZE];
		int cnt = 0;
		for(int i=0; i<m.length; i++) {
			if(m[i]!=null) {
				if(email.equals(m[i].getEmail())) {
					m2[cnt] = m[i];
					cnt++;
				}
			}
		}
		return m2;
	}
	
	public Boolean updatePassword(String id, String password) {
		boolean check = false;
		for(int i =0; i<m.length; i++) {
			if(m[i]!=null) {
				if(m[i].getId().equals(id)) {
					check = true;
					m[i].setPassword(password);
					break;
				}
			}
		}
		return check;
	}
	
	public Boolean updateName(String id, String name) {
		boolean check = false;
		for(int i =0; i<m.length; i++) {
			if(m[i]!=null) {
				if(m[i].getId().equals(id)) {
					check = true;
					m[i].setName(name);
					break;
				}
			}
		}
		return check;
	}
	
	public Boolean updateEmail(String id, String email) {
		boolean check = false;
		for(int i =0; i<m.length; i++) {
			if(m[i]!=null) {
				if(m[i].getId().equals(id)) {
					check = true;
					m[i].setEmail(email);
					break;
				}
			}
		}
		return check;
	}
	
	public Boolean delete(String id) {
		boolean check = false;
		for(int i =0; i<m.length; i++) {
			if(m[i]!=null) {
				if(m[i].getId().equals(id)) {
					check = true;
					m[i] = null;
					break;
				}
			}
		}
		return check;
	}
	
	public void delete() {
		m = null;
	}
	
	public Member[] printAll() {
		return m;
	}
	
}
