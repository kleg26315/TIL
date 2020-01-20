package com.kh.example.chap01_byte.run;

import com.kh.example.chap01_byte.model.dao.ByteDAO;

public class Run {
	public static void main(String[] args) {
		ByteDAO bd = new ByteDAO();
		bd.fileOpen();
//		bd.fileSave();
	}
}
