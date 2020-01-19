package com.kh.practice.list.library.model.vo;

public class Book implements Comparable<Book>{
	private String title;
	private String author;
	private String category;
	private int price;
	
	public Book() {}
	public Book(String title, String author, String category, int price) {
		this.title = title;
		this.author = author;
		this.category =category;
		this.price =price;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "("+title+"/"+author+"/"+category+"/"+price+")";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((category==null) ? 0 : category.hashCode());
		result = prime * result + price;
		
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj==null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		
		Book m = (Book)obj;
		if(title == null) {
			if(m.title != null)
				return false;
		}
		else if(!title.equals(m.title))
				return false;
		
		if(author == null) {
			if(m.author != null)
				return false;
		}
		else if(!author.equals(m.author))
			return false;
		
		if(category == null) {
			if(m.category != null)
				return false;
		}
		else if(!category.equals(m.category))
			return false;
		
		if(price != m.price)
			return false;
		
		
		return true;
	}
	@Override
	public int compareTo(Book o) {
		String otherTitle = o.getTitle();
		
		return title.compareTo(otherTitle);
	}
	
}
