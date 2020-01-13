package com.kh.practice.point.controller;

import com.kh.practice.point.model.vo.Circle;
import com.kh.practice.point.model.vo.Rectangle;

public class RectangleController {
	private Rectangle r = new Rectangle();
	
	public String calcArea(int x, int y, int height, int width) {
		r = new Rectangle(x,y, width, height);
		double calc = height * width;
		return "면적 : "+r.toString()+" / "+(int)calc;
	}
	
	public String calcPerimeter(int x, int y, int height, int width) {
		r = new Rectangle(x,y,width, height);
		double calc =2*( height + width);
		return "둘레 : "+r.toString()+" / "+(int)calc;
	}
	
}
