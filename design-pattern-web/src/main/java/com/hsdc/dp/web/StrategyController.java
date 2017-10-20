package com.hsdc.dp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StrategyController {
	@RequestMapping(value = "/stg", method = RequestMethod.GET)
	public String index(Model model) {
		return "stgindex";
	}
	
	@RequestMapping(value = "/stg/doaction/{inputStr}", method = RequestMethod.GET, produces="text/html;charset=UTF-8")
	public @ResponseBody String doAction(@PathVariable String inputStr) {
		return "output";
	}
}
