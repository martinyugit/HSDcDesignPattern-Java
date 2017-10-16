package com.hsdc.dp.intf.service.command;

public interface CalculationInvoker {
	public void compute(Object receiver, String operator, int operand);
	public void undo();
}
