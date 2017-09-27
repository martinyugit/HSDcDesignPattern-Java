package com.hsdc.dp.intf.domain.interpreter;

import java.util.Iterator;
import java.util.LinkedList;

import com.hsdc.dp.intf.dto.interpreter.ChineseNumber;

public final class MoneyContext {
	private LinkedList<String> chineseChars = new LinkedList<String>();
    public LinkedList<String> getChineseChars() {
		return chineseChars;
	}

	public LinkedList<Integer> getNumInts() {
		return numInts;
	}

	private LinkedList<Integer> numInts = new LinkedList<Integer>();
    
    public MoneyContext(long number)
    {
    	for (char c :( new Long(number)).toString().toCharArray())
    		numInts.addLast(Character.getNumericValue(c));
    }
    
    public String toChinese() {
    	String chineseNum = "";
    	Iterator<String> x = chineseChars.descendingIterator();
    	while (x.hasNext())
    		chineseNum += x.next();
    	if (chineseNum.substring(chineseNum.length()-1).equals(ChineseNumber.ZERO.getValue()))
    		chineseNum = chineseNum.substring(0, chineseNum.length() - 1);
    	return chineseNum;
    }
}
