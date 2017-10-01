package com.hsdc.dp.service.interpreter;

import org.springframework.stereotype.Service;

import com.hsdc.dp.intf.domain.interpreter.MoneyContext;
import com.hsdc.dp.intf.domain.interpreter.MoneyExpression;
import com.hsdc.dp.intf.service.interpreter.MoneyUco;

@Service
public class MoneyUcoImpl implements MoneyUco {

	public MoneyContext transferToChinese(MoneyContext context, MoneyExpression prior) {
		if (context.getNumInts().size() == 0)
            return context;
        MoneyExpression expression = new NumericExpression((NumericExpression)prior);
        expression.interpret(context);
        context.getNumInts().removeFirst();
        if (context.getNumInts().size() > 0)
        {
            context = this.transferToChinese(context, expression);
        }
        return context;
	}

}
