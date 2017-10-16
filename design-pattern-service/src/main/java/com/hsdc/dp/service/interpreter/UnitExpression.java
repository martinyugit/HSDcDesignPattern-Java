package com.hsdc.dp.service.interpreter;

import com.hsdc.dp.intf.domain.interpreter.MoneyContext;
import com.hsdc.dp.intf.domain.interpreter.MoneyExpression;
import com.hsdc.dp.intf.dto.interpreter.ChineseUnit;

class UnitExpression extends MoneyExpression {
	private NumberExpression currentNumber;
    private ChineseUnit cu;
    public UnitExpression(NumberExpression currentNumber)
    {
        this.currentNumber = currentNumber;
    }

	@Override
	public void interpret(MoneyContext context) {
		int unit = context.getNumInts().size() - 1;
        if (unit == 0)
            return;
        else if (unit % 4 > 0)
            unit = unit % 4;
        cu = ChineseUnit.fromDigit(unit);
        if ((currentNumber != null) && (currentNumber.isZero()))
        {
            if (this.lessThan4())
                return;
            else if (this.greatThan3())
            {
                try
                {
                    ChineseUnit preCu = ChineseUnit.fromUnit(context.getChineseChars().getFirst());
                    if ((preCu.getDigit() > 3) && (this.greatThan3()))
                        return;
                }
                catch(Exception e) { }
                context.getChineseChars().removeFirst();
            }
        }
        try
        {
            ChineseUnit preCu = ChineseUnit.fromUnit(context.getChineseChars().getFirst());
            if ((preCu.getDigit() > 3) && (this.greatThan3()))
                return;
        }
        catch(Exception e) { }
        context.getChineseChars().addFirst(cu.getUnit());
	}
	
	private boolean lessThan4()
    {
        return cu.getDigit() < 4;
    }

    private boolean greatThan3()
    {
        return cu.getDigit() > 3;
    }

}
