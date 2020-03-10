package com.kh.board.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.board.model.vo.Board;

public class BoardDAO {

	private Properties prop = null;
	
	public BoardDAO() {
		try {
			prop = new Properties();
			prop.load(new FileReader("query.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Board> selectAll(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<Board> bList = null;
		
		String query = prop.getProperty("selectAll");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			bList = new ArrayList<Board>();
			
			Board board = null;
			while(rset.next()) {
				int bNo = rset.getInt("BNO");
				String title = rset.getString("TITLE");
				String content = rset.getString("CONTENT");
				Date createDate = rset.getDate("CREATE_DATE");
				String writer = rset.getString("WRITER");
				
				board = new Board(bNo, title, content, createDate, writer);
				
				bList.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return bList;
	}

	public Board selectOne(Connection conn, int no) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Board board = null;
		
		String query = prop.getProperty("selectOne");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				int bNo = rset.getInt("BNO");
				String title = rset.getString("TITLE");
				String content = rset.getString("CONTENT");
				Date createDate = rset.getDate("CREATE_DATE");
				String writer = rset.getString("WRITER");
				
				board = new Board(bNo, title, content, createDate, writer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return board;
	}

	public int insertBoard(Connection conn, Board board) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertBoard");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setString(3, board.getWriter());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Board> checkMember(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> bList = new ArrayList<>();
		
		String query = prop.getProperty("checkMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			
			rset = pstmt.executeQuery();
			
			Board board = null;
			while(rset.next()) {
				int bNo = rset.getInt("BNO");
				String title = rset.getString("TITLE");
				String content = rset.getString("CONTENT");
				Date createDate = rset.getDate("CREATE_DATE");
				String writer = rset.getString("WRITER");
				
				board = new Board(bNo, title, content, createDate, writer);
				
				bList.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return bList;
	}

	public int updateTitle(Connection conn,String memberId, int sel, String title, int no) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateTitle");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, title);
			pstmt.setString(2, memberId);
			pstmt.setInt(3, no);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateContent(Connection conn, String memberId, int sel, String content, int no) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateContent");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, content);
			pstmt.setString(2, memberId);
			pstmt.setInt(3, no);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteBoard(Connection conn, String memberId, int no) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteBoard");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			pstmt.setInt(2, no);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

}
