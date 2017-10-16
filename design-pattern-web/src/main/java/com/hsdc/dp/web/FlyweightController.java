package com.hsdc.dp.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hsdc.dp.intf.dto.flyweight.CodeDto;
import com.hsdc.dp.service.flyweight.CodeFactory;

@Controller
public class FlyweightController {
	@RequestMapping(value = "/fw", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("codes", CodeFactory.getInstance().getCode("CITY").getCodeList(""));
		return "fwindex";
	}
	
	@RequestMapping(value = "/fw/qa/{parent}", method = RequestMethod.GET)
	public @ResponseBody List<CodeDto> queryArea(@PathVariable String parent) {
		return CodeFactory.getInstance().getCode("AREA").getCodeList(parent);
	}
}
