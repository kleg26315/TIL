package com.kh.board.model.service;

import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.board.model.dao.BoardDAO;
import com.kh.board.model.vo.Board;

public class BoardService {

	public ArrayList<Board> selectAll() {
		Connection conn = getConnection();
		
		BoardDAO bDAO = new BoardDAO();
		
		ArrayList<Board> bList = bDAO.selectAll(conn);
		
		return bList;
	}

	public Board selectOne(int no) {
		Connection conn = getConnection();
		BoardDAO bDAO = new BoardDAO();
		
		Board board = bDAO.selectOne(conn, no);
		
		return board;
	}

	public int insertBoard(Board board) {
		Connection conn = getConnection();
		BoardDAO bDAO = new BoardDAO();
		
		int result = bDAO.insertBoard(conn, board);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
		
	}

	public ArrayList<Board> checkMember(String memberId) {
		Connection conn = getConnection();
		
		BoardDAO bDAO = new BoardDAO();
		ArrayList<Board> bList = bDAO.checkMember(conn, memberId);
		
		return bList;
	}

	public int updateTitle(String memberId, int sel, String title, int no) {
		Connection conn = getConnection();
		BoardDAO bDAO = new BoardDAO();
		
		int result = bDAO.updateTitle(conn, memberId, sel, title, no);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}

	public int updateContent(String memberId, int sel, String content, int no) {
		Connection conn = getConnection();
		BoardDAO bDAO = new BoardDAO();
		
		int result = bDAO.updateContent(conn, memberId, sel, content, no);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}

	public int deleteBoard(String memberId, int no) {
		Connection conn = getConnection();
		BoardDAO bDAO = new BoardDAO();
		
		int result = bDAO.deleteBoard(conn, memberId, no);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}


}
