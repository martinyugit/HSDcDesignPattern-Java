package com.hsdc.dp.service.strategy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hsdc.dp.intf.service.cor.HandlerUco;
import com.hsdc.dp.intf.service.strategy.Strategy;
import com.hsdc.dp.intf.service.strategy.StrategyUco;

@Service
public class StrategyUcoImpl implements StrategyUco {
	
	public static void execute(Strategy strategy) {
		strategy.solve();
	}
	
	public String execute(String[] inputStrategy) {
		List<Strategy> strategyList = new ArrayList<Strategy>();
		for(String strategy : inputStrategy) {
			if(strategy.equals("FOO")) {
				strategyList.add(new FOO());
			}
			if(strategy.equals("BAR")) {
				strategyList.add(new BAR());
			}			
		}		
		
		for(Strategy strategy : strategyList) {
			execute(strategy);
		}
		
		return null;
	}

}
