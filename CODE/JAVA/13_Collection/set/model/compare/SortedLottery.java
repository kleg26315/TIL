package com.kh.practice.set.model.compare;

import java.util.Comparator;

import com.kh.practice.set.model.vo.Lottery;

public class SortedLottery implements Comparator<Lottery>{

	@Override
	public int compare(Lottery o1, Lottery o2) {
		String standardName = o1.getName();
		String objectName = o2.getName();
		
		String standardPhone = o1.getPhone();
		String objectPhone = o2.getPhone();
		
		if(standardName == objectName) {
			return standardPhone.compareTo(objectPhone);
		}
		else {
			return standardName.compareTo(objectName);
		}
	}

}
