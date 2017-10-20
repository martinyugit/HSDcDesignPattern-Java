package com.hsdc.dp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hsdc.dp.intf.service.cor.HandlerUco;

@Controller
public class ChainOfResponsibilityController {
	
	@RequestMapping(value = "/cor", method = RequestMethod.GET)
	public String index(Model model) {
		return "corindex";
	}

	@Autowired private HandlerUco uco;
	@RequestMapping(value = "/cor/inputNum/{inputNum}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String action(@PathVariable int inputNum) {
		String out = uco.execute(inputNum);
		System.out.println(out);
		return out;
	}
}
