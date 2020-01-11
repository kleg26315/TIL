package com.kh.hw.member.view;

import java.util.Scanner;

import com.kh.hw.member.controller.MemberController;

public class MemberMenu {
	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	
	public MemberMenu() {}
	public void mainMenu() {
		while(true) {
			System.out.println("최대 등록 가능한 회원 수는 "+mc.SIZE+"명입니다.");
			System.out.println("현재 등록된 회원 수는 "+mc.exitsMemberNum()+"명입니다.");
			if(mc.exitsMemberNum()!=mc.SIZE) {
				System.out.println("1. 새 회원 등록");
			}
			else {
				System.out.println("회원 수가 모두 꽉 찼기 때문에 일부 메뉴만 오픈됩니다.");
			}
			System.out.println("2. 회원 검색");
			System.out.println("3. 회원 정보 수정");
			System.out.println("4. 회원 삭제");
			System.out.println("5. 모두 출력");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 번호 : ");
			int menuItem = Integer.parseInt(sc.nextLine());
			
			switch(menuItem) {
			case 1: 
				if(mc.exitsMemberNum()!=mc.SIZE) {
					insertMember();
				}
				else {
					System.out.println("회원 수가 모두 꽉 찼기 때문에 추가는 불가합니다.");
				}
				break;
			case 2:
				searchMember(); break;
			case 3:
				updateMember(); break;
			case 4:
				deleteMember(); break;
			case 5:
				printAll(); break;
			case 9:
				System.out.println("프로그램을 종료합니다.\n"); break;
			default:
				System.out.println("잘못 입력하셨습니다.");
			}
			if(menuItem==9)
				break;
		}
	}
	
	public void insertMember() {
		System.out.println("새 회원을 등록합니다.");
		String id;
		while(true) {
			System.out.print("아이디 : ");
			id = sc.nextLine();
			if(mc.checkId(id)==true) {
				System.out.println("중복된 아이디입니다. 다시 입력해주세요.");
			}
			else {
				break;
			}
		}
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("비밀번호 : ");
		String password = sc.nextLine();
		System.out.print("이메일 : ");
		String email = sc.nextLine();
		char gender;
		while(true) {
			System.out.print("성별(M/F) : ");
			gender = sc.nextLine().charAt(0);
			if(gender=='M'||gender=='F'||gender=='m'||gender=='f') {
				break;
			}
			else {
				System.out.println("성별을 다시 입력하세요.");
			}
		}
		System.out.print("나이 : ");
		int age = Integer.parseInt(sc.nextLine());
		mc.insertMember(id, name, password, email, gender, age);
	}
	
	public void searchMember() {
		System.out.println("1. 아이디로 검색하기");
		System.out.println("2. 이름으로 검색하기");
		System.out.println("3. 이메일로 검색하기");
		System.out.println("9. 메인으로 돌아가기");
		System.out.print("메뉴 번호 : ");
		int menuItem = Integer.parseInt(sc.nextLine());
		
		switch(menuItem) {
		case 1: searchId(); break;
		case 2: searchName(); break;
		case 3: searchEmail(); break;
		case 9:
			System.out.println("메인으로 돌아갑니다.\n");
			break;
		default:
			System.out.println("잘못 입력하셨습니다.\n");
		}
	}
	
	public void searchId() {
		System.out.print("검색할 아이디 : ");
		String id = sc.nextLine();
		if(mc.searchId(id).equals("")) {
			System.out.println("검색 결과가 없습니다.\n");
		}
		else {
			System.out.println("찾으신 회원 조회 결과입니다.");
			System.out.println(mc.searchId(id));
			System.out.println();
		}
	}
	
	public void searchName() {
		System.out.print("검색할 이름 : ");
		String name = sc.nextLine();
		int cnt =0;
		for(int i =0; i<mc.searchName(name).length; i++) {
			if(mc.searchName(name)[i]!=null) {
				cnt++;
			}
		}
		if(cnt==0) {
			System.out.println("검색 결과가 없습니다.\n");
		}
		else {
			System.out.println("찾으신 회원 조회 결과입니다.");
			for(int i=0; i<cnt; i++) {
				System.out.println(mc.searchName(name)[i].inform());
			}
			System.out.println();
		}
	}
	
	public void searchEmail() {
		System.out.print("검색할 이메일 : ");
		String email = sc.nextLine();
		int cnt =0;
		for(int i =0; i<mc.searchEmail(email).length; i++) {
			if(mc.searchEmail(email)[i]!=null) {
				cnt++;
			}
		}
		if(cnt==0) {
			System.out.println("검색 결과가 없습니다.\n");
		}
		else {
			System.out.println("찾으신 회원 조회 결과입니다.");
			for(int i=0; i<cnt; i++) {
				System.out.println(mc.searchEmail(email)[i].inform());
			}
			System.out.println();
		}
	}
	
	public void updateMember() {
		System.out.println("1. 비밀번호 수정하기");
		System.out.println("2. 이름 수정하기");
		System.out.println("3. 이메일 수정하기");
		System.out.println("9. 메인으로 돌아가기");
		System.out.print("메뉴 번호 : ");
		int menuItem = Integer.parseInt(sc.nextLine());
		
		switch(menuItem) {
		case 1: updatePassword(); break;
		case 2: updateName(); break;
		case 3: updateEmail(); break;
		case 9:
			System.out.println("메인으로 돌아갑니다.\n");
			break;
		default:
			System.out.println("잘못 입력하셨습니다.\n");
		}
	}
	
	public void updatePassword() {
		System.out.print("수정할 회원의 아이디 : ");
		String id = sc.nextLine();
		System.out.print("수정할 비밀번호 : ");
		String password = sc.nextLine();
		if(mc.updatePassword(id, password)==true) {
			System.out.println("수정이 성공적으로 되었습니다.\n");
		}
		else {
			System.out.println("존재하지 않는 아이디입니다.\n");
		}
	}
	
	public void updateName() {
		System.out.print("수정할 회원의 아이디 : ");
		String id = sc.nextLine();
		System.out.print("수정할 이름 : ");
		String name = sc.nextLine();
		if(mc.updateName(id, name)==true) {
			System.out.println("수정이 성공적으로 되었습니다.\n");
		}
		else {
			System.out.println("존재하지 않는 아이디입니다.\n");
		}
	}
	
	public void updateEmail() {
		System.out.print("수정할 회원의 아이디 : ");
		String id = sc.nextLine();
		System.out.print("수정할 이메일 : ");
		String email = sc.nextLine();
		if(mc.updateEmail(id, email)==true) {
			System.out.println("수정이 성공적으로 되었습니다.\n");
		}
		else {
			System.out.println("존재하지 않는 아이디입니다.\n");
		}
	}
	
	public void deleteMember() {
		System.out.println("1. 특정 회원 삭제하기");
		System.out.println("2. 모든 회원 삭제하기");
		System.out.println("9. 메인으로 돌아가기");
		System.out.print("메뉴 번호 : ");
		int menuItem = Integer.parseInt(sc.nextLine());
		
		switch(menuItem) {
		case 1: deleteOne(); break;
		case 2: deleteAll(); break;
		case 9:
			System.out.println("메인으로 돌아갑니다.\n");
			break;
		default:
			System.out.println("잘못 입력하셨습니다.\n");
		}
	}
	
	public void deleteOne() {
		System.out.print("삭제할 회원의 아이디 : ");
		String id = sc.nextLine();
		System.out.print("정말 삭제하시겠습니까?(y/n) : ");
		char isCheck = sc.nextLine().charAt(0);
		if(isCheck=='y'||isCheck=='y') {
			if(mc.delete(id)==true){
				System.out.println("성공적으로 삭제하였습니다.\n");
			}
			else {
				System.out.println("존재하지 않는 아이디입니다.\n");
			}
		}
		else if(isCheck=='n'||isCheck=='N'){
			System.out.println("메인메뉴로 돌아갑니다.\n");
		}
		else {
			System.out.println("잘못 입력하셨습니다. 메인메뉴로 돌아갑니다.\n");
		}
	}
	
	public void deleteAll() {
		System.out.print("정말 삭제하시겠습니까?(y/n) : ");
		char isCheck = sc.nextLine().charAt(0);
		if(isCheck=='y'||isCheck=='y') {
			mc.delete();
			System.out.println("성공적으로 삭제하였습니다.\n");
		}
		else if(isCheck=='n'||isCheck=='N'){
			System.out.println("메인메뉴로 돌아갑니다.\n");
		}
		else {
			System.out.println("잘못 입력하셨습니다. 메인메뉴로 돌아갑니다.\n");
		}
	}
	
	public void printAll() {
		int cnt=0;
		
		if(mc.printAll()==null) {
			System.out.println("저장된 회원이 없습니다.\n");
		}
		else{
			for(int i=0; i<mc.printAll().length; i++) {	
				if(mc.printAll()[i]!=null) {
					System.out.println(mc.printAll()[i].inform());
					cnt++;
				}
			}
			if(cnt == 0)
				System.out.println("저장된 회원이 없습니다.\n");
			System.out.println();
		}
	}
	
}
