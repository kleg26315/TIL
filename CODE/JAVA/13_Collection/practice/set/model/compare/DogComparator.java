package com.kh.example.set.model.compare;

import java.util.Comparator;

import com.kh.example.set.model.vo.Dog;

public class DogComparator implements Comparator<Dog>{

	@Override
	public int compare(Dog o1, Dog o2) {
		String originName = o1.getName();
		String objectName = o2.getName();
		
		double originWeight = o1.getWeight();
		double objectWeight = o2.getWeight();
		
		if(originWeight > objectWeight)
			return 1;
		else if(originWeight == objectWeight)
//			return 0;
			return originName.compareTo(objectName);		
		else
			return -1;
	}

}
