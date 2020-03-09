package com.kh.controller;

import java.util.ArrayList;

import com.kh.model.service.MemberService;
import com.kh.model.vo.Member;
import com.kh.view.MemberMenu;

public class MemberController {
	private MemberMenu menu = new MemberMenu();
//	private MemberDAO md = new MemberDAO();
	private MemberService service = new MemberService();
	
	public void insertMember() {
		Member member = menu.insertMember();
		
		int result = service.insertMember(member);
		
		if(result >0) {
			menu.displaySucces(result +"개의 행이 추가되었습니다.");
		} else {
			menu.displayError("데이터 삽입 과정 중 오류 발생");
		}
	}
	
	public void selectAll() {
		ArrayList<Member> mList = service.selectAll();
		
		if(!mList.isEmpty()) {
			menu.displayMember(mList);
		} else {
			menu.displayError("조회 결과가 없습니다.");
		}
	}

	public void selectMember() {
		// 검색 조건의 번호를 반환 받아 저장
		int sel = menu.selectMember();
		ArrayList<Member> mList = null;
		
		switch(sel) {
		case 1:
			String id = menu.inputMemberId();
			mList =service.selectMemberId(id);
			break;
		case 2:
			char gender = menu.inputGender();
			mList = service.selectGender(gender);
			break;
		case 0: return;
		}
		
		if(!mList.isEmpty()) {
			menu.displayMember(mList);
		} else {
			menu.displayError("조회 결과가 없습니다.");
		}
	}
	
	public void updateMember() {
		// 아이디 받아오기
		String memberId = menu.inputMemberId();
		
		// 받아온 아이디가 존재하는지 체크
		int check = service.checkMember(memberId);
		
		if(check != 1) {
			menu.displayError("입력한 아이디가 존재하지 않습니다.");
		} else {
			int sel = menu.updateMember();
			
			if(sel == 0) return;
			
			String input = menu.inputUpdate();
			
			int result = service.updateMember(memberId, sel, input);
			
			if(result >= 0) {
				menu.displaySucces(result + "개의 행이 수정되었습니다.");
			} else {
				menu.displayError("데이터 수정 과정 중 오류 발생");
			}
		}
	}

	public void deleteMember() {
		// 아이디 받아오기
		String memberId = menu.inputMemberId();
		
		// 받아온 아이디가 존재하는지 체크
		int check = service.checkMember(memberId);
		
		if(check != 1) {
			menu.displayError("입력한 아이디가 존재하지 않습니다.");
		} else {
			int result = service.deleteMember(memberId);
			
			if(result >= 0) {
				menu.displaySucces(result + "개의 행이 삭제되었습니다.");
			} else {
				menu.displayError("데이터 삭제 과정 중 오류 발생");
			}
		}
	}
}

}
