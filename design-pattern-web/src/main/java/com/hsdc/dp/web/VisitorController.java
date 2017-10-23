package com.hsdc.dp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VisitorController {
	
	@RequestMapping(value = "/vt", method = RequestMethod.GET)
	public String index(Model model) {
		return "vtindex";
	}
	
	@RequestMapping(value = "/vt/action", method = RequestMethod.GET, produces="text/html;charset=UTF-8")
	public void action(@RequestParam(value="inputIdx") int idx, @RequestParam(value="inputNum") String num) {
	}

}
