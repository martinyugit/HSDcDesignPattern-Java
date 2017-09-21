package com.hsdc.dp.web;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hsdc.dp.service.singleton.IDGeneratorSingleton;
import com.hsdc.dp.web.dto.SingletonStringResponse;

@Controller
public class SingletonController {
	@RequestMapping(value = "/sg", method = RequestMethod.GET)
	public String index(Model model) {
		return "sgindex";
	}
	
	@RequestMapping(value = "/sg/genid/{formType}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody SingletonStringResponse genId(@PathVariable String formType) {
		return new SingletonStringResponse(IDGeneratorSingleton.getInstance().getNextID(formType, Calendar.getInstance().getTime()));
	}
}
