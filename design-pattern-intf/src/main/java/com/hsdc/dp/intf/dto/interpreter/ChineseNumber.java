package com.hsdc.dp.intf.dto.interpreter;

import java.util.HashMap;
import java.util.Map;

public enum ChineseNumber {
	ONE(1, "壹"),TWO(2, "貳"),THREE(3, "參"),FOUR(4, "肆"),FIVE(5, "伍"),
	SIX(6, "陸"),SEVEN(7, "柒"),EIGHT(8, "捌"),NINE(9, "玖"),ZERO(0, "零"),;
	
	private int key;
	private String value;
	
	private static Map<Integer, ChineseNumber> keysToChineseNumber = new HashMap<Integer, ChineseNumber>();
	static {
		for (ChineseNumber cn : ChineseNumber.values()) keysToChineseNumber.put(cn.key, cn);
	}
	
	ChineseNumber(int key, String value) {
		this.key = key;
		this.value = value;
	}
	
	public int getKey() {
		return this.key;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public static ChineseNumber fromKey(int key) {
		ChineseNumber target = keysToChineseNumber.get(key);
		if (target == null) throw new RuntimeException("No Such Key!");
		return target;
	}
}
