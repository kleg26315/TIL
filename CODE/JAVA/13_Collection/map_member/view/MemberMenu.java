package com.kh.practice.map.view;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import com.kh.practice.map.controller.MemberController;
import com.kh.practice.map.model.vo.Member;

public class MemberMenu {
	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	
	public void mainMenu() {
		System.out.println("========= KH 사이트 =========\n");
		
		while(true) {
			System.out.println("******* 메인 메뉴 *******");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 같은 이름 회원 찾기");
			System.out.println("9. 종료\n");
			System.out.print("메뉴 번호 선택 : ");
			int menuItem = Integer.parseInt(sc.nextLine());
			
			switch(menuItem) {
			case 1: joinMembership(); break;
			case 2: logIn(); memberMenu(); break;
			case 3: sameName(); break;
			case 9: System.out.println("프로그램 종료"); return;
			default: System.out.println("잘못 입력하였습니다. 다시 입력해주세요.\n");
			}	
		}
		
	}
	
	public void memberMenu() {
		while(true) {
			System.out.println("******* 회원 메뉴 *******");
			System.out.println("1. 비밀번호 바꾸기");
			System.out.println("2. 이름 바꾸기");
			System.out.println("3. 로그아웃\n");
			System.out.print("메뉴 번호 선택 : ");
			int menuItem = Integer.parseInt(sc.nextLine());
			
			switch(menuItem) {
			case 1: changePasswrod(); break;
			case 2: changeName(); break;
			case 3: System.out.println("로그아웃 되었습니다.\n"); return;
			default: System.out.println("잘못 입력하였습니다. 다시 입력해주세요.\n");
			}	
		}
	}
	
	public void joinMembership() {
		while(true) {
			System.out.print("아이디 : ");
			String id = sc.nextLine();
			System.out.print("비밀번호 : ");
			String password = sc.nextLine();
			System.out.print("이름 : ");
			String name = sc.nextLine();
			
			if(mc.joinMembership(id, new Member(password, name))==true) {
				System.out.println("성공적으로 회원가입 완료하였습니다.");
				break;
			}
			else {
				System.out.println("중복된 아이디입니다. 다시 입력해주세요.");
			}	
		}
	}
	
	public void logIn() {
		while(true) {
			System.out.print("아이디 : ");
			String id = sc.nextLine();
			System.out.print("비밀번호 : ");
			String password = sc.nextLine();
			String check = mc.logIn(id, password);
			if(check==null){
				System.out.println("틀린 아이디 또는 비밀번호입니다. 다시 입력해주세요.");
			}
			else {
				System.out.println(check+"님, 환영합니다!");
				break;
			}
		}
	}
	
	public void changePasswrod() {
		while(true) {
			System.out.print("아이디 : ");
			String id = sc.nextLine();
			System.out.print("현재 비밀번호 : ");
			String oldPw = sc.nextLine();
			System.out.print("새로운 비밀번호 : ");
			String newPw = sc.nextLine();
			if(mc.changePassword(id, oldPw, newPw)==true) {
				System.out.println("비밀번호 변경에 성공했습니다.");
				break;
			}
			else {
				System.out.println("비밀번호 변경에 실패했습니다. 다시 입력해주세요.");
			}			
		}
	}
	
	public void changeName() {
		while(true) {
			System.out.print("아이디 : ");
			String id = sc.nextLine();
			System.out.print("비밀번호 : ");
			String password = sc.nextLine();
			String originName = mc.logIn(id, password);
			if(originName==null) {
				System.out.println("이름 변경에 실패했습니다. 다시 입력해주세요");
			}
			else {
				System.out.println("현재 설정된 이름 : "+originName);
				System.out.print("변경할 이름 : ");
				String newName = sc.nextLine();
				mc.changeName(id, newName);
				System.out.println("이름 변경에 성공하였습니다.");
				break;
			}
			
		}		
	}
	
	public void sameName() {
		System.out.print("검색할 이름 : ");
		String searchName = sc.nextLine();
		TreeMap<String, String> treeMap = new TreeMap<String, String>();
		treeMap = mc.sameName(searchName);
		if(treeMap.isEmpty()==true) {
			System.out.println(searchName+"님과 같은 이름의 회원이 존재하지 않습니다.");
		}
		else {
			Set<Entry<String,String>> set = new HashSet<Entry<String,String>>();
			set = treeMap.entrySet();
			Iterator<Entry<String,String>> it = set.iterator();
			
			while(it.hasNext()) {
				Entry<String,String> entry = it.next();
				System.out.println(entry.getValue()+"-"+entry.getKey());
			}
		}
			
	}
	
}
