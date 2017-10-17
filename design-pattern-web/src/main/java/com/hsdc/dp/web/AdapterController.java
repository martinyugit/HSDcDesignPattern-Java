package com.hsdc.dp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.SessionScope;

import com.hsdc.dp.intf.service.memento.LottoUco;

@Controller
public class AdapterController {
	
	@RequestMapping(value = "/ad", method = RequestMethod.GET)
	public String index(Model model) {
		return "adindex";
	}
	
	@RequestMapping(value = "/ad/update", method = RequestMethod.GET, produces="text/html;charset=UTF-8")
	public void update(@RequestParam(value="inputIdx") int idx, @RequestParam(value="inputNum") String num) {
	}

}
