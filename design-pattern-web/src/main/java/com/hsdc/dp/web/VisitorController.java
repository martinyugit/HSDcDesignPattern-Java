package com.hsdc.dp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hsdc.dp.intf.service.visitor.VisitorUco;

@Controller
public class VisitorController {
	
	@RequestMapping(value = "/vt", method = RequestMethod.GET)
	public String index(Model model) {
		return "vtindex";
	}
	
	@Autowired private VisitorUco uco;
	@RequestMapping(value = "/vt/execute/{inputVisitor}", method = RequestMethod.GET, produces="text/html;charset=UTF-8")
	public @ResponseBody String execute(@PathVariable String inputVisitor) {
		System.out.println("-----------------------------------------------");
		uco.execute(inputVisitor);
		return "on console...";
	}
}
