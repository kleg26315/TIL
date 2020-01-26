package com.kh.practice.generics.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.kh.practice.generics.controller.FarmController;
import com.kh.practice.generics.model.vo.Farm;
import com.kh.practice.generics.model.vo.Fruit;
import com.kh.practice.generics.model.vo.Nut;
import com.kh.practice.generics.model.vo.Vegetable;

public class FarmMenu {
	private Scanner sc = new Scanner(System.in);
	private FarmController fc = new FarmController();
	
	public void mainMenu() {
		System.out.println("========= KH 마트 =========\n");
		while(true) {
			System.out.println("******* 메인 메뉴 *******");
			System.out.println("1. 직원 메뉴");
			System.out.println("2. 손님 메뉴");
			System.out.println("9. 종료\n");
			System.out.print("메뉴 번호 선택 : ");
			int menuItem = Integer.parseInt(sc.nextLine());
			
			switch(menuItem) {
			case 1: adminMenu(); break;
			case 2: customerMenu(); break;
			case 9: System.out.println("프로그램 종료"); return;
			default : System.out.println("잘못 입력하였습니다. 다시 입력해주세요.\n");
			}	
		}		
	}
	
	public void adminMenu() {
		while(true) {
			System.out.println("******* 직원 메뉴 *******");
			System.out.println("1. 새 농산물 추가");
			System.out.println("2. 종류 삭제");
			System.out.println("3. 수량 수정");
			System.out.println("4. 농산물 목록");
			System.out.println("9. 메인으로 돌아가기\n");
			System.out.print("메뉴 번호 선택 : ");
			int menuItem = Integer.parseInt(sc.nextLine());
			
			switch(menuItem) {
			case 1: addNewKind(); break;
			case 2: removeKind(); break;
			case 3: changeAmount(); break;
			case 4: printFarm(); break;
			case 9: return;
			default : System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}	
		}
	}
	
	public void customerMenu() {
		while(true) {
			System.out.println("현재 KH마트 농산물 수량");
			printFarm();
			System.out.println();
			System.out.println("******* 고객 메뉴 *******");
			System.out.println("1. 농산물 사기");
			System.out.println("2. 농산물 빼기");
			System.out.println("3. 구입한 농산물 보기");
			System.out.println("9. 메인으로 돌아가기\n");
			System.out.print("메뉴 번호 선택 : ");
			int menuItem = Integer.parseInt(sc.nextLine());
			
			switch(menuItem) {
			case 1: buyFarm(); break;
			case 2: removeFarm(); break;
			case 3: printBuyFarm(); break;
			case 9: return;
			default : System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}	
		}
	}
	
	public void addNewKind() {
		while(true) {
			System.out.println("1. 과일 / 2. 채소 / 3. 견과");
			System.out.print("추가할 종류 번호 : ");
			int item = Integer.parseInt(sc.nextLine());
			String kind = null;
			switch(item) {
			case 1: kind = "과일"; break;
			case 2: kind = "채소"; break;
			case 3: kind = "견과"; break;
			default : System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
			if(kind != null) {
				System.out.print("이름 : ");
				String name = sc.nextLine();
				System.out.print("수량 : ");
				int amount = Integer.parseInt(sc.nextLine());
				
				if(kind.equals("과일")) {
					if(fc.addNewKind(new Fruit(kind,name), amount)== true) {
						System.out.println("새 농산물이 추가되었습니다.");
						break;
					}
					else {
						System.out.println("새 농산물 추가에 실패하였습니다. 다시 입력해주세요.");
					}
				}
				else if(kind.equals("채소")) {
					if(fc.addNewKind(new Vegetable(kind,name), amount)==true) {
						System.out.println("새 농산물이 추가되었습니다.");
						break;
					}
					else {
						System.out.println("새 농산물 추가에 실패하였습니다. 다시 입력해주세요.");
					}
				}
				else if(kind.equals("견과")){
					if(fc.addNewKind(new Nut(kind,name), amount)==true) {
						System.out.println("새 농산물이 추가되었습니다.");
						break;
					}
					else {
						System.out.println("새 농산물 추가에 실패하였습니다. 다시 입력해주세요.");
					}
				}
			}
		}
	}
	
	public void removeKind() {
		while(true) {
			System.out.println("1. 과일 / 2. 채소 / 3. 견과");
			System.out.print("삭제할 종류 번호 : ");
			int item = Integer.parseInt(sc.nextLine());
			String kind = null;
			switch(item) {
			case 1: kind = "과일"; break;
			case 2: kind = "채소"; break;
			case 3: kind = "견과"; break;
			default : System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
			if(kind != null) {
				System.out.print("이름 : ");
				String name = sc.nextLine();
				if(kind.equals("과일")) {
					if(fc.removeKind(new Fruit(kind,name))== true) {
						System.out.println("농산물 삭제에 성공하였습니다.");
						break;
					}
					else {
						System.out.println("농산물 삭제에 실패하였습니다. 다시 입력해주세요.");
					}
				}
				else if(kind.equals("채소")) {
					if(fc.removeKind(new Vegetable(kind,name))== true) {
						System.out.println("농산물 삭제에 성공하였습니다.");
						break;
					}
					else {
						System.out.println("농산물 삭제에 실패하였습니다. 다시 입력해주세요.");
					}
				}
				else if(kind.equals("견과")){
					if(fc.removeKind(new Nut(kind,name))== true) {
						System.out.println("농산물 삭제에 성공하였습니다.");
						break;
					}
					else {
						System.out.println("농산물 삭제에 실패하였습니다. 다시 입력해주세요.");
					}
				}
			}
		}
	}
	
	public void changeAmount() {
		while(true) {
			System.out.println("1. 과일 / 2. 채소 / 3. 견과");
			System.out.print("수정할 종류 번호 : ");
			int item = Integer.parseInt(sc.nextLine());
			String kind = null;
			switch(item) {
			case 1: kind = "과일"; break;
			case 2: kind = "채소"; break;
			case 3: kind = "견과"; break;
			default : System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
			if(kind != null) {
				System.out.print("이름 : ");
				String name = sc.nextLine();
				System.out.print("수정할 수량 : ");
				int amount = Integer.parseInt(sc.nextLine());
				
				if(kind.equals("과일")) {
					if(fc.changeAmount(new Fruit(kind,name), amount)== true) {
						System.out.println("농산물 수량이 수정되었습니다.");
						break;
					}
					else {
						System.out.println("농산물 수량 수정에 실패하였습니다. 다시 입력해주세요.");
					}
				}
				else if(kind.equals("채소")) {
					if(fc.changeAmount(new Vegetable(kind,name),amount)== true) {
						System.out.println("농산물 수량이 수정되었습니다.");
						break;
					}
					else {
						System.out.println("농산물 수량 수정에 실패하였습니다. 다시 입력해주세요.");
					}
				}
				else if(kind.equals("견과")){
					if(fc.changeAmount(new Nut(kind,name),amount)== true) {
						System.out.println("농산물 수량이 수정되었습니다.");
						break;
					}
					else {
						System.out.println("농산물 수량 수정에 실패하였습니다. 다시 입력해주세요.");
					}
				}
			}
		}
	}
	
	public void printFarm() {
		Map<Farm, Integer> map = new HashMap<Farm, Integer>();
		map = fc.printFarm();
		Set<Farm> set = new HashSet<Farm>();
		set = map.keySet();
		Iterator<Farm> it = set.iterator();
		while(it.hasNext()) {
			Farm f = it.next();
			if( f instanceof Fruit) {
				System.out.println(f.getKind()+" : "+((Fruit) f).getName()+"("+map.get(f)+"개)");
			}
			else if( f instanceof Vegetable) {
				System.out.println(f.getKind()+" : "+((Vegetable) f).getName()+"("+map.get(f)+"개)");
			}
			else if( f instanceof Nut) {
				System.out.println(f.getKind()+" : "+((Nut) f).getName()+"("+map.get(f)+"개)");
			}
		}
	}
	
	public void buyFarm() {
		while(true) {
			System.out.println("1. 과일 / 2. 채소 / 3. 견과");
			System.out.print("구매할 종류 번호 : ");
			int item = Integer.parseInt(sc.nextLine());
			String kind = null;
			switch(item) {
			case 1: kind = "과일"; break;
			case 2: kind = "채소"; break;
			case 3: kind = "견과"; break;
			default : System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
			if(kind != null) {
				System.out.print("구매할 것 : ");
				String name = sc.nextLine();
				
				if(kind.equals("과일")) {
					if(fc.buyFarm(new Fruit(kind,name))== true) {
						System.out.println("구매에 성공하였습니다.");
						break;
					}
					else {
						System.out.println("마트에 없는 물건이거나 수량이 없습니다. 다시 입력해주세요.");
					}
				}
				else if(kind.equals("채소")) {
					if(fc.buyFarm(new Vegetable(kind,name))== true) {
						System.out.println("구매에 성공하였습니다.");
						break;
					}
					else {
						System.out.println("마트에 없는 물건이거나 수량이 없습니다. 다시 입력해주세요.");
					}
				}
				else if(kind.equals("견과")){
					if(fc.buyFarm(new Nut(kind,name))== true) {
						System.out.println("구매에 성공하였습니다.");
						break;
					}
					else {
						System.out.println("마트에 없는 물건이거나 수량이 없습니다. 다시 입력해주세요.");
					}
				}
			}
		}
	}
	
	public void removeFarm() {
		while(true) {
			System.out.println("1. 과일 / 2. 채소 / 3. 견과");
			System.out.print("삭제할 종류 번호 : ");
			int item = Integer.parseInt(sc.nextLine());
			String kind = null;
			switch(item) {
			case 1: kind = "과일"; break;
			case 2: kind = "채소"; break;
			case 3: kind = "견과"; break;
			default : System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
			if(kind != null) {
				System.out.print("구매 취소할 것 : ");
				String name = sc.nextLine();
				
				if(kind.equals("과일")) {
					if(fc.removeFarm(new Fruit(kind,name))== true) {
						System.out.println("구매 취소에 성공하였습니다.");
						break;
					}
					else {
						System.out.println("구매매 목록에 존재하지 않습니다. 다시 입력해주세요.");
					}
				}
				else if(kind.equals("채소")) {
					if(fc.removeFarm(new Vegetable(kind,name))== true) {
						System.out.println("구매 취소에 성공하였습니다.");
						break;
					}
					else {
						System.out.println("구매매 목록에 존재하지 않습니다. 다시 입력해주세요.");
					}
				}
				else if(kind.equals("견과")){
					if(fc.removeFarm(new Nut(kind,name))== true) {
						System.out.println("구매 취소에 성공하였습니다.");
						break;
					}
					else {
						System.out.println("구매매 목록에 존재하지 않습니다. 다시 입력해주세요.");
					}
				}
			}
		}
	}
	
	public void printBuyFarm() {
		List<Farm> list = new ArrayList<Farm>();
		list = fc.printBuyFarm();
		Iterator<Farm> it = list.iterator();
		
		while(it.hasNext()) {
			Farm f = it.next();
			if( f instanceof Fruit) {
				System.out.println(f.getKind()+" : "+((Fruit) f).getName());
			}
			else if( f instanceof Vegetable) {
				System.out.println(f.getKind()+" : "+((Vegetable) f).getName());
			}
			else if( f instanceof Nut) {
				System.out.println(f.getKind()+" : "+((Nut) f).getName());
			}
		}
		
	}
}
