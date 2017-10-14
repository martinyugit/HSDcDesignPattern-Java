package com.hsdc.dp.intf.dto.interpreter;

import java.util.HashMap;
import java.util.Map;

public enum ChineseUnit {
	TEN(1, "拾"),HUNDRED(2, "佰"),THOUSAND(3, "仟"),TENTHOUSAND(4, "萬"),HUNDREDMILLION(8, "億"),
	THOUSANDBILLION(12, "兆"),;
	
	private int digit;
	private String unit;
	
	private static Map<Integer, ChineseUnit> digitsForChineseUnit = new HashMap<Integer, ChineseUnit>();
	private static Map<String, ChineseUnit> unitsForChineseUnit = new HashMap<String, ChineseUnit>();
	
	static {
		for (ChineseUnit u: ChineseUnit.values()) {
			digitsForChineseUnit.put(u.digit, u);
			unitsForChineseUnit.put(u.unit, u);
		}
	}
	
	ChineseUnit(int digit, String unit) {
		this.digit = digit;
		this.unit = unit;
	}
	
	public int getDigit() {
		return this.digit;
	}
	
	public String getUnit() {
		return this.unit;
	}
	
	public static ChineseUnit fromDigit(int digit) {
		ChineseUnit target = digitsForChineseUnit.get(digit);
		if (target == null) throw new RuntimeException("No Such Digit");
		return target;
	}
	
	public static ChineseUnit fromUnit(String unit) {
		ChineseUnit target = unitsForChineseUnit.get(unit);
		if (target == null) throw new RuntimeException("No Such Unit");
		return target;
	}
}
