package com.hsdc.dp.service.domain.command;

public final class ElementaryArithCommand extends Command {
	private ElementaryArithCaculator _caculator;

	public ElementaryArithCommand(Object receiver, String operator, int operand) {
		super(receiver, EOperator.queryOperator(operator), operand);
		if (receiver instanceof ElementaryArithCaculator)
            this._caculator = (ElementaryArithCaculator)receiver;
	}

	@Override
	public void execute() {
		if (this._caculator != null)
            this._caculator.operation(operator.getOperator(), operand);
	}

	@Override
	public void unExecute() {
		if (this._caculator != null)
            this._caculator.operation(operator.getUndoOperator(), operand);
	}

}
