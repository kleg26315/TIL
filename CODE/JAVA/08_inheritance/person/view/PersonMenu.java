package com.kh.hw.person.view;

import java.util.Scanner;

import com.kh.hw.person.controller.PersonController;

public class PersonMenu {
	private Scanner sc = new Scanner(System.in);
	private PersonController pc = new PersonController();
	
	public void mainMenu() {
		while(true) {
			System.out.println("학생은 최대 3명까지 저장할 수 있습니다.");
			int cntStudent = pc.personCount()[0];
			System.out.println("현재 저장된 학생은 "+cntStudent+"명 입니다.");
			System.out.println("사원은 최대 10명까지 저장할 수 있습니다.");
			int cntEmployee = pc.personCount()[1];
			System.out.println("현재 저장된 사원은 "+cntEmployee+"명 입니다.\n");
			
			System.out.println("1. 학생 메뉴");
			System.out.println("2. 사원 메뉴");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 번호 : ");
			int menuItem= Integer.parseInt(sc.nextLine());
			System.out.println();
			
			switch(menuItem) {
			case 1: studentMenu(); break;
			case 2: employeeMenu();  break;
			case 9: System.out.println("종료합니다.\n"); break;
			default : System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.\n");
			}
			if(menuItem==9) {
				break;
			}	
		}
	}
	public void studentMenu() {
		while(true) {
			int cntStudent = pc.personCount()[0];
			int flag =0;
			System.out.println("1. 학생 추가");
			System.out.println("2. 학생 보기");
			System.out.println("9. 메인으로");
			if(cntStudent==3) {
				System.out.println("학생을 담을 수 있는 공간이 꽉 차기 때문에 학생 추가 메뉴는 더 이상 활성화 되지 않습니다.");
				flag = 1;
			}
			System.out.print("메뉴 번호 : ");
			int menuItem = Integer.parseInt(sc.nextLine());
			
			switch(menuItem) {
			case 1: 
				if(flag==1) {
					System.out.println("잘못 입력하셨습니다. 다시 입력해주세요\n");
				}else {
					insertStudent();
				}
				break;
			case 2: printStudent(); break;
			case 9: System.out.println("메인으로 돌아갑니다.\n"); break;
			default : System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.\n");
			}
			if(menuItem==9)
				break;
		}
	}
	public void employeeMenu() {
		while(true) {
			int cntEmployee = pc.personCount()[1];
			int flag =0;
			System.out.println("1. 사원 추가");
			System.out.println("2. 사원 보기");
			System.out.println("9. 메인으로");
			if(cntEmployee==10) {
				System.out.println("사원을 담을 수 있는 공간이 꽉 차기 때문에 사원 추가 메뉴는 더 이상 활성화 되지 않습니다.");
				flag = 1;
			}
			System.out.print("메뉴 번호 : ");
			int menuItem = Integer.parseInt(sc.nextLine());
			
			switch(menuItem) {
			case 1: 
				if(flag==1) {
					System.out.println("잘못 입력하셨습니다. 다시 입력해주세요\n");
				}else {
					insertEmployee();
				}
				break;
			case 2: printEmployee(); break;
			case 9: System.out.println("메인으로 돌아갑니다.\n"); break;
			default : System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.\n");
			}
			
			if(menuItem==9)
				break;
		}
	}
	public void insertStudent() {
		System.out.println();
		while(true) {
			System.out.print("학생 이름 : ");
			String name = sc.nextLine();
			System.out.print("학생 나이 : ");
			int age = Integer.parseInt(sc.nextLine());
			System.out.print("학생 키 : ");
			double height = Double.parseDouble(sc.nextLine());
			System.out.print("학생 몸무게 : ");
			double weight = Double.parseDouble(sc.nextLine());
			System.out.print("학생 학년 : ");
			int grade = Integer.parseInt(sc.nextLine());
			System.out.print("학생 전공 : ");
			String major = sc.nextLine();
			
			pc.insertStudent(name, age, height, weight, grade, major);
			int cntStudent = pc.personCount()[0];
			if(cntStudent < 3) {
				System.out.print("그만하시려면 N(또는 n),이어하시려면 아무 키나 누르세요 : ");
				char isCheck = sc.nextLine().charAt(0);
				
				if(isCheck=='N'||isCheck=='n') {
					break;
				}
			}
			else {
				System.out.println("학생을 담을 수 있는 공간이 꽉 찼기 때문에 학생 추가를 종료하고 학생 메뉴로 돌아갑니다.\n");
				break;
			}
		}
	}
	public void printStudent() {
		System.out.println();
		for(int i=0; i<pc.printStudent().length; i++) {
			if(pc.printStudent()[i] != null)
				System.out.println(pc.printStudent()[i]);
		}
		System.out.println();
	}
	public void insertEmployee() {
		System.out.println();
		while(true) {
			System.out.print("사원 이름 : ");
			String name = sc.nextLine();
			System.out.print("사원 나이 : ");
			int age = Integer.parseInt(sc.nextLine());
			System.out.print("사원 키 : ");
			double height = Double.parseDouble(sc.nextLine());
			System.out.print("사원 몸무게 : ");
			double weight = Double.parseDouble(sc.nextLine());
			System.out.print("사원 급여 : ");
			int salary = Integer.parseInt(sc.nextLine());
			System.out.print("사원 부서 : ");
			String dept = sc.nextLine();
			
			pc.insertEmployee(name, age, height, weight, salary, dept);
			int cntEmployee = pc.personCount()[1];
			if(cntEmployee < 10) {
				System.out.print("그만하시려면 N(또는 n),이어하시려면 아무 키나 누르세요 : ");
				char isCheck = sc.nextLine().charAt(0);
				
				if(isCheck=='N'||isCheck=='n') {
					break;
				}
			}
			else {
				System.out.println("사원을 담을 수 있는 공간이 꽉 찼기 때문에 사원 추가를 종료하고 사원 메뉴로 돌아갑니다.\n");
				break;
			}
		}
	}
	public void printEmployee() {
		System.out.println();
		for(int i=0; i<pc.printEmployee().length; i++) {
			if(pc.printEmployee()[i] != null)
				System.out.println(pc.printEmployee()[i]);
		}
		System.out.println();
	}
}
