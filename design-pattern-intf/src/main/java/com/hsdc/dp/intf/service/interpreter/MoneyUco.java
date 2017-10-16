package com.hsdc.dp.intf.service.interpreter;

import com.hsdc.dp.intf.domain.interpreter.MoneyContext;
import com.hsdc.dp.intf.domain.interpreter.MoneyExpression;

public interface MoneyUco {
	public MoneyContext transferToChinese(MoneyContext context, MoneyExpression prior);
}
