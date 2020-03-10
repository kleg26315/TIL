package com.kh.board.controller;

import java.util.ArrayList;

import com.kh.board.model.service.BoardService;
import com.kh.board.model.vo.Board;
import com.kh.view.View;

public class BoardController {
	private View view = new View();
	private BoardService service = new BoardService();
	
	public void selectAll() {
		ArrayList<Board> bList = service.selectAll();
		
		if(!bList.isEmpty()) {
			view.selectAll(bList);
		} else {
			view.displayError("조회 결과가 없습니다.");
		}
	}

	public void selectOne() {
		int no = view.inputBNo();
		
		Board board = service.selectOne(no);
		
		if(board != null) {
			view.selectOne(board);
		} else {
			view.displayError("조회 결과가 없습니다.");
		}
	}

	public void insertBoard() {
		Board board = view.insertBoard();
		
		int result = service.insertBoard(board);
		
		if(result > 0) {
			view.displaySuccess(result + "개의 행이 추가되었습니다.");
		} else {
			view.displayError("데이터 삽입 과정 중 오류 발생");
		}
	}

	public void updateBoard() {
		String memberId = view.getMemberId(); 
		
		ArrayList<Board> bList = service.checkMember(memberId);
		
		if(!bList.isEmpty()) {
			view.selectAll(bList);
			int no = view.inputBNo();
			Board board = service.selectOne(no);
			
			if(board != null) {
				int sel = view.updateMenu();
				int result = 0;
				switch(sel) {
				case 1: 
					String title = view.updateTitle();
					result = service.updateTitle(memberId, sel, title, no);
					break;
				case 2: 
					String content = view.updateContent(); 
					result = service.updateContent(memberId, sel, content, no);
					break;
				case 0: return;
				}
				
				if(result >= 0) {
					view.displaySuccess(result +"개의 행이 수정되었습니다.");
				} else {
					view.displayError("데이터 수정 과정 중 오류 발생");
				}
			} else {
				view.displayError("조회 결과가 없습니다.");
			}
			
		} else {
			view.displayError("회원님으로 작성된 글이 없습니다.");
		}
		
	}

	public void deleteBoard() {
		String memberId = view.getMemberId(); 
		
		ArrayList<Board> bList = service.checkMember(memberId);
		
		if(!bList.isEmpty()) {
			view.selectAll(bList);
			int no = view.inputBNo();
			Board board = service.selectOne(no);
			
			if(board != null) {
				char yn = view.deleteBoard();
				if(yn=='Y') {
					int result = 0;
					result = service.deleteBoard(memberId, no);
					
					if(result >= 0) {
						view.displaySuccess(result +"개의 행이 삭제되었습니다.");
					} else {
						view.displayError("데이터 삭제 과정 중 오류 발생");
					}
				} else {
					view.displayError("삭제를 취소하였습니다.");
				}
				
			} else {
				view.displayError("조회 결과가 없습니다.");
			}
			
		} else {
			view.displayError("회원님으로 작성된 글이 없습니다.");
		}
		
	}

}
