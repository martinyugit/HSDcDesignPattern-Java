package com.hsdc.dp.service.interpreter;

import com.hsdc.dp.intf.domain.interpreter.MoneyContext;
import com.hsdc.dp.intf.domain.interpreter.MoneyExpression;
import com.hsdc.dp.intf.dto.interpreter.ChineseNumber;

class NumberExpression extends MoneyExpression {
	private NumberExpression prior;
    private ChineseNumber cn;
    
    public NumberExpression(NumberExpression prior)
    {
        this.prior = prior;
    }

	@Override
	public void interpret(MoneyContext context) {
		int value = context.getNumInts().getFirst();
        cn = ChineseNumber.fromKey(value);
        if ((prior != null) && (prior.isZero()) && (prior.cn == cn))
            return;
        context.getChineseChars().addFirst(cn.getValue());
        return;
	}
	
	public boolean isZero()
    {

        return cn == ChineseNumber.ZERO;
    }

}
