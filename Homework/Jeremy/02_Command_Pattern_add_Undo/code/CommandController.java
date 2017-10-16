package com.hsdc.dp.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hsdc.dp.intf.service.command.CalculationInvoker;
import com.hsdc.dp.service.domain.command.ElementaryArithCaculator;

@Controller
@Scope("session")
public class CommandController {
	@RequestMapping(value = "/cmd", method = RequestMethod.GET)
	public String index() {
		return "cmdindex";
	}
	
	@Autowired private CalculationInvoker invoker;
	
	@RequestMapping(value = "/cmd/cmpt", method = RequestMethod.GET)
	public @ResponseBody Integer compute(HttpSession session, @RequestParam(value="operand") int operand,
			@RequestParam(value="operator") String operator) {
		ElementaryArithCaculator receiver;
		if (session.getAttribute("calculator") == null)
			session.setAttribute("calculator", new ElementaryArithCaculator());
		receiver = (ElementaryArithCaculator)session.getAttribute("calculator");
		invoker.compute(receiver, operator, operand);
		return receiver.getResult();
	}
	
	@RequestMapping(value = "/cmd/undo", method = RequestMethod.GET)
	public @ResponseBody Integer undo(HttpSession session) {
		ElementaryArithCaculator receiver;
		if (session.getAttribute("calculator") == null)
			session.setAttribute("calculator", new ElementaryArithCaculator());
		receiver = (ElementaryArithCaculator)session.getAttribute("calculator");
		invoker.undo();
		return receiver.getResult();
	}
	
	@RequestMapping(value = "/cmd/clr", method = RequestMethod.GET)
	public @ResponseBody Integer clear(HttpSession session) {
		ElementaryArithCaculator receiver = new ElementaryArithCaculator();
		session.setAttribute("calculator", receiver);
		return receiver.getResult();
	}
}
