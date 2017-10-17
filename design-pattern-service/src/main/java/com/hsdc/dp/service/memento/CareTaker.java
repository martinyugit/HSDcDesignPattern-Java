package com.hsdc.dp.service.memento;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {
	
	List<Memento> mementoList = new ArrayList<Memento>();

	public List<Memento> getMementoList() {
		return mementoList;
	}
	
	public void setMemento(int idx, Memento m) {
		if(idx == -1) {
			mementoList.add(m);
		}
		else {
			mementoList.set(idx, m);
		}
	}

	public void deleteMemento(int idx) {
		mementoList.remove(idx);
	}
}
