package com.kh.board.model.vo;

import java.sql.Date;

public class Board {
	private int bNo;
	private String title;
	private String content;
	private Date createDate;
	private String writer;
	
	public Board() {}
	public Board(int bNo, String title, String content, Date createDate, String writer) {
		this.bNo = bNo;
		this.title = title;
		this.content = content;
		this.createDate = createDate;
		this.writer = writer;
	}
	
	public Board(int bNo, String title, String content) {
		this.bNo = bNo;
		this.title = title;
		this.content = content;
	}
	
	public Board(String title, String content, String writer) {
		this.title = title;
		this.content = content;
		this.writer = writer;
	}
	
	public Board(String title, String content) {
		this.title = title;
		this.content = content;
	}
	public int getbNo() {
		return bNo;
	}
	public void setbNo(int bNo) {
		this.bNo = bNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	@Override
	public String toString() {
		return bNo +", "+ title +", "+ content +", "+ createDate +", "+ writer;
	}
}
