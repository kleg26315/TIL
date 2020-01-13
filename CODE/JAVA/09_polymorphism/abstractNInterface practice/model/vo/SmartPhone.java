package com.kh.practice.chap02_abstractNInterface.model.vo;

public abstract class SmartPhone implements CellPhone, TouchDisplay{
	private String maker;
	
	public SmartPhone() {}
	public abstract String printInformation();
	
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public String getMaker() {
		return maker;
	}

}
