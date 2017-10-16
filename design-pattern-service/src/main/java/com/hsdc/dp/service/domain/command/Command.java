package com.hsdc.dp.service.domain.command;

public abstract class Command {
	protected String operator;
    protected int operand;
    public abstract void execute();
    public Command(Object receiver, String operator, int operand) 
    {
        this.operator = operator;
        this.operand = operand;
    }
}
