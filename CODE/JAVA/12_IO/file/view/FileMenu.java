package com.kh.practice.file.view;

import java.util.Scanner;

import com.kh.practice.file.controller.FileController;

public class FileMenu {
	private Scanner sc = new Scanner(System.in);
	private FileController fc = new FileController();
	
	public void mainMenu() {
		while(true) {
			System.out.println("***** My Note *****");
			System.out.println("1. 노트 새로 만들기");
			System.out.println("2. 노트 열기");
			System.out.println("3. 노트 열어서 수정하기");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 번호 : ");
			int menuItem = Integer.parseInt(sc.nextLine());
			
			switch(menuItem) {
			case 1: fileSave(); break;
			case 2: fileOpen(); break;
			case 3: fileEdit(); break;
			case 9: System.out.println("프로그램을 종료합니다."); break;
			default : System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.\n");
			}
			if(menuItem == 9)
				break;
		}
		
	}
	
	public void fileSave() {
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			System.out.println("파일에 저장할 내용을 입력하세요.");
			System.out.println("ex끝it 이라고 입력하면 종료됩니다.");
			System.out.print("내용 : ");
			String str = sc.nextLine();
			if(str.equals("ex끝it")) {
				while(true) {
					System.out.print("저장할 파일 명을 입력해주세요(ex. myFile.txt) : ");
					String file = sc.nextLine();
					if(fc.checkName(file) == true) {
						System.out.print("이미 존재하는 파일입니다. 덮어쓰시겠습니까?(y/n) : ");
						char isCheck = sc.nextLine().charAt(0);
						if(isCheck=='y'||isCheck=='y') {
							fc.fileSave(file, sb);
							break;
						}
					}
					else {
						fc.fileSave(file, sb);
						break;
					}
				}
				break;
			}
			else{
				sb.append(str);
				sb.append("\n");
			}
		}
	}
	
	public void fileOpen() {
		System.out.print("열 파일 명 : ");
		String file = sc.nextLine();
		
		if(fc.checkName(file)== true) {
			System.out.println(fc.fileOpen(file));
		}
		else {
			System.out.println("없는 파일입니다.\n");
		}
	}
	
	public void fileEdit() {
		System.out.print("수정할 파일 명 : ");
		String file = sc.nextLine();
		
		if(fc.checkName(file)==false) {
			System.out.println("없는 파일입니다. \n");
		}
		else {
			StringBuilder sb = new StringBuilder();
			while(true) {
				System.out.println("파일에 저장할 내용을 입력하세요.");
				System.out.println("ex끝it 이라고 입력하면 종료됩니다.");
				System.out.print("내용 : ");
				String str = sc.nextLine();
				
				if(str.equals("ex끝it")) {
					fc.fileEdit(file, sb);
					break;
				}
				else{
					sb.append(str);
					sb.append("\n");
				}
			}
		}
	}
}
