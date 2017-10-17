package com.hsdc.dp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hsdc.dp.intf.domain.interpreter.MoneyContext;
import com.hsdc.dp.intf.service.interpreter.MoneyUco;

@Controller
public class InterpreterController {
	@RequestMapping(value = "/itp", method = RequestMethod.GET)
	public String index() {
		return "itindex";
	}
	
	@Autowired private MoneyUco uco;
	@RequestMapping(value = "/itp/toch", method = RequestMethod.GET, produces="text/html;charset=UTF-8")
	public @ResponseBody String transfer(@RequestParam(value="number") long number) {
		MoneyContext context = new MoneyContext(number);
		context = uco.transferToChinese(context, null);
		String result = context.toChinese();
		return result;
	}
}
