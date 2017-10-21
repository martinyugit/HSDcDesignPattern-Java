package com.hsdc.dp.service.strategy;

import com.hsdc.dp.intf.service.strategy.Strategy;

public class StrategyDemo {

	public static void execute(Strategy strategy) {
		strategy.solve();
	}
	
	public static void main(String[] args) {
		Strategy[] strategyList = {new FOO(), new BAR()};
		for(Strategy strategy : strategyList) {
			execute(strategy);
		}

	}
}
