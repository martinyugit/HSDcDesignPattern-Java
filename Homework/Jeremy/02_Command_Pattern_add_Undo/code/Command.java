package com.hsdc.dp.service.domain.command;

public abstract class Command {
	protected EOperator operator;
    protected int operand;
    public abstract void execute();
    public abstract void unExecute();
    public Command(Object receiver, EOperator operator, int operand) 
    {
        this.operator = operator;
        this.operand = operand;
    }
}
