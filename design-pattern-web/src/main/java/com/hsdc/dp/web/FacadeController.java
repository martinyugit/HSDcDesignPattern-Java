package com.hsdc.dp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hsdc.dp.intf.service.facade.ServiceUco;

@Controller
public class FacadeController {
	
	@RequestMapping(value = "/fc", method = RequestMethod.GET)
	public String index(Model model) {
		return "fcindex";
	}
	
	@Autowired private ServiceUco uco;
	@RequestMapping(value = "/fc/doaction", method = RequestMethod.GET, produces="text/html;charset=UTF-8")
	public @ResponseBody String transfer(@RequestParam(value="string") String string) {
		String result = uco.doAction(string);
		return result;
	}
	
}
