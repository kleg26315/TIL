package com.kh.hw.person.controller;

import com.kh.hw.person.model.vo.Employee;
import com.kh.hw.person.model.vo.Student;

public class PersonController {
	private Student[] s= new Student[3];
	private Employee[] e = new Employee[10];
	
	public int[] personCount() {
		int[] count = new int[2];
		int cntStudent =0;
		int cntEmployee =0;
		if(s==null) {
			
		}
		else {
			for(int i =0; i<s.length; i++) {
				if(s[i]!=null)
					cntStudent++;
			}
		}
		if(e==null) {
			
		}
		else {
			for(int i=0; i<e.length; i++) {
				if(e[i] !=null)
					cntEmployee++;
			}
		}
		count[0] = cntStudent;
		count[1] = cntEmployee;
		return count;
	}
	public void insertStudent(String name, int age, double height, double weight, int grade, String major) {
		for(int i =0; i<s.length; i++) {
			if(s[i] == null) {
				s[i] = new Student(name, age, height, weight, grade,major);
				break;
			}
		}
	}
	public Student[] printStudent() {
		return s;
	}
	public void insertEmployee(String name, int age, double height, double weight, int salary, String dept) {
		for(int i =0; i<e.length; i++) {
			if(e[i] == null) {
				e[i] = new Employee(name, age, height, weight,salary,dept);
				break;
			}
		}
	}
	public Employee[] printEmployee() {
		return e;
	}
}
