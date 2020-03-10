package com.kh.member.controller;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;
import com.kh.view.View;

public class MemberController {
	private MemberService mService = new MemberService();
	private View view = new View();
	
	public void login() {
		Member mem = view.inputLogin();
		
		int result = mService.login(mem);
		
		if(result > 0) {
			view.displayLoginSuccess();
		} else {
			view.displayLoginError();
		}
	}
}
