package com.kh.example.chap02_abstractInterface.family.model.vo;

import java.io.Serializable;

public interface Basic extends Cloneable, Serializable{
	//						   ----------------------- ==> Marker Interface
	// 													: 이 마커 인터페이스는 상속받은 클래스가 이러한 특성이 있어요 라는 표시를 남겨준다.
	/*public abstract*/ void eat();
	/*public abstract*/ void sleep(); 
}
