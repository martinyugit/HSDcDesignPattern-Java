package com.hsdc.dp.service.domain.command;

public enum EOperator {
	ADD("+", "-"), MINUS("-", "+"), MUTIPLE("*", "/"), DIVIDE("/", "*"), UNKNOW("", "");
	
	private String operator;
	private String undoOperator;
	
	private EOperator(String operator, String undoOperator) {
		this.setOperator(operator);
		this.setUndoOperator(undoOperator);
	}
	
	public String getOperator() {
		return operator;
	}
	
	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getUndoOperator() {
		return undoOperator;
	}

	public void setUndoOperator(String undoOperator) {
		this.undoOperator = undoOperator;
	}

	public static EOperator queryOperator(String operator) {
		EOperator[] values = EOperator.values();
		
		for(EOperator op: values) {
			if(op.getOperator().equals(operator)) {
				return op;
			}
		}
		
		return UNKNOW;
	}
	
	
}
