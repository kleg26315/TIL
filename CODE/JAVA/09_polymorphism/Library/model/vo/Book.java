package com.kh.practice.chap01_poly.model.vo;

public class Book {
	private String title;
	private String author;
	private String publisher;
	
	public Book() {}
	public Book(String title, String author, String publisher) {
		this.title = title;
		this.author = author;
		this.publisher = publisher;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[Book [title="+title+", author="+author+", publisher="+publisher+"]";
	}
}
