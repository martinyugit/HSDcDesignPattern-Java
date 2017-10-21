package com.hsdc.dp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hsdc.dp.intf.service.strategy.StrategyUco;

@Controller
public class StrategyController {
	@RequestMapping(value = "/stg", method = RequestMethod.GET)
	public String index(Model model) {
		return "stgindex";
	}
	
	@Autowired private StrategyUco uco;
	@RequestMapping(value = "/stg/execute/{inputStrategy}", method = RequestMethod.GET, produces="text/html;charset=UTF-8")
	public @ResponseBody String execute(@PathVariable String[] inputStrategy) {
		System.out.println("-----------------------------------------------");
		uco.execute(inputStrategy);
		return "on console...";
	}
}
