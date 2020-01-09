package com.kh.hw.shape.view;

import java.util.Scanner;

import com.kh.hw.shape.controller.SquareController;
import com.kh.hw.shape.controller.TriangleController;

public class ShapeMenu {
	private Scanner sc = new Scanner(System.in);
	private SquareController scr = new SquareController();
	private TriangleController tc = new TriangleController();
	
	public void inputMenu() {
		while(true) {
			System.out.println("===== 도형 프로그램 =====");
			System.out.println("3. 삼각형");
			System.out.println("4. 사각형");
			System.out.println("9. 프로그램 종료");
			System.out.print("메뉴 번호 : ");
			int menuItem = Integer.parseInt(sc.nextLine());
			switch(menuItem) {
			case 3: triangleMenu(); break;
			case 4: squareMenu(); break;
			case 9 : System.out.println("프로그램을 종료합니다."); break;
			default : System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
			}
			if(menuItem==9) {
				break;
			}
		}
		
	}
	
	public void triangleMenu() {
		while(true) {
			System.out.println("===== 삼각형 =====");
			System.out.println("1. 삼각형 면적");
			System.out.println("2. 삼각형 색칠");
			System.out.println("3. 삼각형 정보");
			System.out.println("9. 메인으로");
			System.out.print("메뉴 번호 : ");
			int menuItem = Integer.parseInt(sc.nextLine());
			switch(menuItem) {
			case 1: inputSize(3,1); break;
			case 2: inputSize(3,2); break;
			case 3: printInformation(3); break;
			case 9 : System.out.println("메인으로 돌아갑니다."); break;
			default : System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
			}
			if(menuItem==9) {
				break;
			}
		}
	}
	
	public void squareMenu() {
		while(true) {
			System.out.println("===== 사각형 =====");
			System.out.println("1. 사각형 둘레");
			System.out.println("2. 사각형 면적");
			System.out.println("3. 사각형 색칠");
			System.out.println("4. 사각형 정보");
			System.out.println("9. 메인으로");
			System.out.print("메뉴 번호 : ");
			int menuItem = Integer.parseInt(sc.nextLine());
			switch(menuItem) {
			case 1: inputSize(4,1); break;
			case 2: inputSize(4,2); break;
			case 3: inputSize(4,3); break;
			case 4: printInformation(4); break;
			case 9 : System.out.println("메인으로 돌아갑니다."); break;
			default : System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
			}
			if(menuItem==9) {
				break;
			}
		}
	}
	
	public void inputSize(int type, int menuNum) {
		if(type==3 && menuNum ==1) {
			System.out.print("높이 : ");
			int height = Integer.parseInt(sc.nextLine());
			System.out.print("너비 : ");
			int width = Integer.parseInt(sc.nextLine());
			
			System.out.println("삼각형 면적 : "+tc.calcArea(height, width));
		}
		else if(type==3 && menuNum==2) {
			System.out.print("색깔을 입력하세요 : ");
			String color = sc.nextLine();
			tc.paintColor(color);
			System.out.println("색이 수정되었습니다.");
		}
		
		if(type==4 && ( menuNum==1 || menuNum ==2) ) {
			System.out.print("높이 : ");
			int height = Integer.parseInt(sc.nextLine());
			System.out.print("너비 : ");
			int width = Integer.parseInt(sc.nextLine());
			
			if(menuNum==1) {
				System.out.println("사각형 둘레 : "+scr.calcPerimeter(height, width));
			}
			else if(menuNum==2) {
				System.out.println("사각형 면적 : "+scr.calcArea(height, width));
			}
		}
		else if(type==4 && menuNum ==3) {
			System.out.print("색깔을 입력하세요 : ");
			String color = sc.nextLine();
			scr.paintColor(color);
			System.out.println("색이 수정되었습니다.");
		}
	}
	
	public void printInformation(int type) {
		if(type == 3) {
			System.out.println(tc.print());
		}
		else if(type == 4) {
			System.out.println(scr.print());
		}
	}
}
