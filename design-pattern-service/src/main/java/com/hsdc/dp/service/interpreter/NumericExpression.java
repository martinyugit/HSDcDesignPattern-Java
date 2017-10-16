package com.hsdc.dp.service.interpreter;

import com.hsdc.dp.intf.domain.interpreter.MoneyContext;
import com.hsdc.dp.intf.domain.interpreter.MoneyExpression;

class NumericExpression extends MoneyExpression {
	 private NumberExpression number;
     private UnitExpression unit;
     private NumericExpression prior = null;
     
     public NumericExpression(NumericExpression prior)
     {
         this.prior = prior;
         number = new NumberExpression(prior == null ? null : prior.getNE());
         unit = new UnitExpression(number);
     }

	@Override
	public void interpret(MoneyContext context) {
		number.interpret(context);
        unit.interpret(context);
	}
	
	public NumberExpression getNE()
    {
        return this.number;
    }
    public UnitExpression getUE()
    {
        return this.unit;
    }

}
