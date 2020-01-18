package com.kh.practice.book.view;

import java.util.Calendar;
import java.util.Scanner;

import com.kh.practice.book.controller.BookController;
import com.kh.practice.book.model.vo.Book;

public class BookMenu {
	private Scanner sc = new Scanner(System.in);
	private BookController bc = new BookController();
	private Book[] bArr;
	
	public BookMenu() {
		bc.makeFile();
		bArr = bc.fileRead();
	}
	
	public void mainMenu() {
		while(true) {
			System.out.println("1. 도서 추가 저장");
			System.out.println("2. 저장 도서 출력");
			System.out.println("9. 프로그램 종료");
			System.out.print("메뉴 번호 : ");
			int menuItem = Integer.parseInt(sc.nextLine());
			
			switch(menuItem) {
			case 1: fileSave(); break;
			case 2: fileRead(); break;
			case 9: System.out.println("프로그램 종료"); break;
			default: System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.\n");
			}
			
			if(menuItem == 9)
				break;
		}
	
	}
	
	public void fileSave() {
		System.out.print("도서 명 : ");
		String title = sc.nextLine();
		System.out.print("저자 명 : ");
		String author = sc.nextLine();
		System.out.print("도서 가격 : ");
		int price = Integer.parseInt(sc.nextLine());
		System.out.print("출판 날짜(yyyy-mm-dd) : ");
		String day = sc.nextLine();
		String[] dateArr = day.split("-");
		int year = Integer.parseInt(dateArr[0]);
		int month = Integer.parseInt(dateArr[1]) -1;
		int date = Integer.parseInt(dateArr[2]);
		
		Calendar c = Calendar.getInstance();
		c.set(year, month, date);
	
		System.out.print("할인율 : ");
		double discount = Double.parseDouble(sc.nextLine());
		for(int i=0; i<bArr.length; i++) {
			if(bArr[i] == null) {
				bArr[i] = new Book(title, author, price, c, discount);
				break;
			}
		}

		bc.fileSave(bArr);
	}
	
	public void fileRead() {
		for(int i=0; i<bArr.length; i++) {
			if(bc.fileRead()[i] != null)
				System.out.println(bc.fileRead()[i]);			
		}
			
	}
}
