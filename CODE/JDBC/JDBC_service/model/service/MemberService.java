package com.kh.model.service;

import static com.kh.common.JDBCTemplate.*;	// static 메소드 이름만 써서 사용하려면 import static 하면된다.

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

public class MemberService {

	public int insertMember(Member member) {
		Connection conn = getConnection();
		
		MemberDAO mDAO = new MemberDAO();
		
		int result = mDAO.insertMember(conn, member);
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}

	public ArrayList<Member> selectAll() {
		Connection conn = getConnection();
		
		MemberDAO mDAO = new MemberDAO();
		
		ArrayList<Member> mList = mDAO.selectAll(conn);
		
		return mList;
	}

	public ArrayList<Member> selectMemberId(String id) {
		Connection conn = getConnection();
		MemberDAO mDAO = new MemberDAO();
		
		ArrayList<Member> mList = mDAO.selectMemberId(conn, id);
		
		return mList;
	}

	public ArrayList<Member> selectGender(char gender) {
		Connection conn = getConnection();
		MemberDAO mDAO = new MemberDAO();
		
		ArrayList<Member> mList = mDAO.selectGender(conn, gender);
		return mList;
	}
	
}
