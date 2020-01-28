package com.kh.example.chap02_control.run;

import com.kh.example.chap02_control.controller.InterruptController;

public class Run {
	public static void main(String[] args) {
		InterruptController ic = new InterruptController();
		ic.sleepInterrupt();
	}
}
