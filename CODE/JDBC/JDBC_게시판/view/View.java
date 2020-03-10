package com.kh.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.board.controller.BoardController;
import com.kh.board.model.vo.Board;
import com.kh.member.controller.MemberController;
import com.kh.member.model.vo.Member;

public class View {
	private Scanner sc = new Scanner(System.in);
	private static Member mem = null;
	
	public void mainMenu() {
		MemberController mc = new MemberController();
		BoardController bc = new BoardController();
		
		int select = 0;
		do {
			System.out.println("\n *** 게시판 프로그램 *** \n");
			
			if(mem == null) {
				System.out.println("1. 로그인");
				System.out.println("0. 프로그램 종료");
				System.out.print("번호 선택 : ");
				select = Integer.parseInt(sc.nextLine());
				
				switch(select) {
				case 1: mc.login(); break;
				case 0: System.out.println("프로그램을 종료합니다."); break;
				default: System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
				}
			} else {
				System.out.println("1. 로그아웃");
				System.out.println("2. 글 목록 조회");
				System.out.println("3. 게시글 상세조회");
				System.out.println("4. 글 쓰기");
				System.out.println("5. 글 수정");
				System.out.println("6. 글 삭제");
				System.out.println("0. 프로그램 종료");
				System.out.print("번호 선택 : ");
				select = Integer.parseInt(sc.nextLine());
				
				switch(select) {
				case 1: mem = null; System.out.println("<< 로그아웃 >>"); break;
				case 2: bc.selectAll(); break;
				case 3: bc.selectOne(); break;
				case 4: bc.insertBoard(); break;
				case 5: bc.updateBoard(); break;
				case 6: bc.deleteBoard(); break;
				case 0: System.out.println("프로그램을 종료합니다."); break;
				default: System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
				}
			}
		}while(select != 0);
		
	}

	public Member inputLogin() {
		mem = new Member();
		
		System.out.println("------ 로그인 ------");
		System.out.print("ID : ");
		mem.setMemberId(sc.nextLine());
		
		System.out.print("PW : ");
		mem.setMemberPwd(sc.nextLine());
		
		return mem;
	}

	public void displayLoginSuccess() {
		System.out.println(mem.getMemberId() + "님 환영합니다.");
	}

	public void displayLoginError() {
		System.out.println("로그인 정보를 확인해주세요.");
		mem = null;
	}
	
	public void selectAll(ArrayList<Board> bList) {
		System.out.printf("%-3s %-15s %-10s %-15s\n", "BNO", "TITLE", "WRITER", "CREATE_DATE");
		System.out.println("---------------------------------------------------");
		for(Board b : bList) {
			System.out.printf("%-3s %-15s %-10s %-15s\n",
								b.getbNo(), b.getTitle(), b.getWriter(), b.getCreateDate());
		}
	}
	
	public void displayError(String msg) {
		System.out.println("서비스 요청 실패 : "+ msg);
	}
	
	public int inputBNo() {
		System.out.print("글 번호 입력 : ");
		int no = Integer.parseInt(sc.nextLine());
		return no;
	}
	
	public void selectOne(Board board) {
		System.out.println();
		System.out.println("---------------------------------------------------");
		System.out.println("글 번호 : "+ board.getbNo());
		System.out.println("제목 : "+ board.getTitle());
		System.out.printf("작성자 : %-10s 작성일 %-15s\n", board.getWriter(), board.getCreateDate());
		System.out.println("---------------------------------------------------");
		System.out.println(board.getContent());
		System.out.println("---------------------------------------------------");
	}
	
	public Board insertBoard() {
		System.out.println("제목 : ");
		String title = sc.nextLine();
		
		StringBuffer content = new StringBuffer();
		StringBuffer str = new StringBuffer();
		System.out.println("----------- 내용 입력(exit 입력 시 종료) -----------");
		while(true) {
			str.delete(0, str.capacity());
			str.append(sc.nextLine());
			
			if(str.toString().toLowerCase().equals("exit")) break;
			
			content.append(str);
			content.append("\n");
		}
		
		Board board = new Board(title, content.toString(), mem.getMemberId());
		return board;
	}
	
	public void displaySuccess(String msg) {
		System.out.println("서비스 요청 성공 : "+msg);
	}
	
	public String getMemberId() {
		return mem.getMemberId();
	}
	
	public int updateMenu() {
		int sel = 0;
		while(true) {
			System.out.println("1. 제목 수정");
			System.out.println("2. 내용 수정");
			System.out.println("0. 메인 메뉴로 이동");
			System.out.print("번호 선택 : ");
			sel = Integer.parseInt(sc.nextLine());
			
			switch(sel) {
			case 1: case 2: case 0: return sel;
			default: System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}
	
	public String updateTitle() {
		System.out.println("제목 : ");
		String title = sc.nextLine();
		return title;
	}
	
	public String updateContent() {
		StringBuffer content = new StringBuffer();
		StringBuffer str = new StringBuffer();
		System.out.println("----------- 내용 입력(exit 입력 시 종료) -----------");
		while(true) {
			str.delete(0, str.capacity());
			str.append(sc.nextLine());
			
			if(str.toString().toLowerCase().equals("exit")) break;
			
			content.append(str);
			content.append("\n");
		}
		
		return content.toString();
	}
	
	public char deleteBoard() {
		System.out.print("정말로 삭제하시겠습니까?(Y/N) : ");
		char yn = sc.nextLine().toUpperCase().charAt(0);
		
		return yn;
	}
}
