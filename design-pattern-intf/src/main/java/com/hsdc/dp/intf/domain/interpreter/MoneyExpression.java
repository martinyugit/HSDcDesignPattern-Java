package com.hsdc.dp.intf.domain.interpreter;

public abstract class MoneyExpression {
	public abstract void interpret(MoneyContext context);
    public int childrenCount()
    {
        return 0;
    }
}
