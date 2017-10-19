package com.hsdc.dp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IteratorController {
	
	@RequestMapping(value = "/itr", method = RequestMethod.GET)
	public String index(Model model) {
		return "itrindex";
	}
	
	@RequestMapping(value = "/itr/action", method = RequestMethod.GET, produces="text/html;charset=UTF-8")
	public void action(@RequestParam(value="inputItr") int idx, @RequestParam(value="inputNum") String num) {
	}

}
