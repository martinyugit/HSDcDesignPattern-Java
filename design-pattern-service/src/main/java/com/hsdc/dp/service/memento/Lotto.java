package com.hsdc.dp.service.memento;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lotto {
	private String number; //4星號碼array
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Memento createMemento() {
		return new Memento(this);
	}
	
	public void setMemento(Memento mem) {
		number = mem.getLotto().getNumber();
	}
	
//	private java.util.Random rndGenerator = new java.util.Random();
//	public final static int NUMBER_OF_VALUES_1_AREA = 37;
//	public final static int NUMBER_OF_VALUES_2_AREA = 7;
	static public String computerSelNum() {
		List<String> number = new ArrayList<String>();
		while(number.size()<6) {
			String num = String.format("%02d", getRandomNumberInRange(1, 38));
			if(!number.contains(num)) {
				number.add(num);
			}
		}
		number.add(String.format("%02d", getRandomNumberInRange(1, 8)));
		
		return String.join(",", number.toArray(new String[0]));
	}

	private static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
}
