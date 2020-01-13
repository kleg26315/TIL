package com.kh.practice.chap01_poly.view;

import java.util.Scanner;

import com.kh.practice.chap01_poly.controller.LibraryController;
import com.kh.practice.chap01_poly.model.vo.Book;
import com.kh.practice.chap01_poly.model.vo.Member;

public class LibraryMenu {
	private LibraryController lc = new LibraryController();
	private Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("나이 : ");
		int age = Integer.parseInt(sc.nextLine());
		System.out.print("성별 : ");
		char gender = sc.nextLine().charAt(0);
		
		Member mem = new Member(name, age, gender);
		lc.insertMember(mem);
		
		while(true) {
			System.out.println();
			System.out.println("==== 메뉴 ====");
			System.out.println("1. 마이페이지");
			System.out.println("2. 도서 전체 조회");
			System.out.println("3. 도서 검색");
			System.out.println("4. 도서 대여하기");
			System.out.println("9. 프로그램 종료하기");
			System.out.print("메뉴 번호 : ");
			int menuItem = Integer.parseInt(sc.nextLine());
			
			switch(menuItem) {
			case 1: System.out.println(lc.myInfo()); break;
			case 2: selectAll(); break;
			case 3: searchBook(); break;
			case 4: rentBook(); break;
			case 9: System.out.println("프로그램을 종료합니다.\n"); break;
			default :
				System.out.println("잘못 입력하셨습니다.\n");
			}
			if(menuItem ==9) {
				break;
			}
		}
	}
	public void selectAll() {
		for(int i =0; i<lc.selectAll().length; i++) {
			if(lc.selectAll()[i] != null) {
				System.out.println(i+"번도서 : "+lc.selectAll()[i]);
			}
		}
	}
	public void searchBook() {
		System.out.println();
		System.out.print("검색할 제목 키워드 : ");
		String keyword = sc.nextLine();
		for(int i =0; i<lc.searchBook(keyword).length; i++) {
			if(lc.searchBook(keyword)[i]!=null)
				System.out.println(lc.searchBook(keyword)[i]);
		}

	}
	public void rentBook() {
		System.out.println();
		selectAll();
		System.out.print("대여할 도서 번호 선택 : ");
		int index = Integer.parseInt(sc.nextLine());
		int result = lc.rentBook(index);
		
		switch(result) {
		case 0: System.out.println("성공적으로 대여되었습니다."); break;
		case 1: System.out.println("나이 제한으로 대여 불가능입니다."); break;
		case 2: System.out.println("성공적으로 대여되었습니다. 요리학원 쿠폰이 발급되었으니 마이페이지에서 확인하세요."); break;
		}
		
	}
}
