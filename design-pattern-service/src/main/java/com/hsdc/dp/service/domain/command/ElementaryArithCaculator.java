package com.hsdc.dp.service.domain.command;

import java.io.Serializable;

public final class ElementaryArithCaculator implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1651714243832653328L;
	
	private int _curr = 0;
	
	public void operation(String operator, int operand) {
		if (operator.equals("+"))
			_curr += operand;
		if (operator.equals("-"))
			_curr -= operand;
		if (operator.equals("*"))
			_curr *= operand;
		if (operator.equals("/"))
			_curr /= operand;
    }
	
	public int getResult() {
        return _curr;
    }
}
