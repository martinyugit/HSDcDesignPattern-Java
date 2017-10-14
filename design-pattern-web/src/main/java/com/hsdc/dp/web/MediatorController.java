package com.hsdc.dp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hsdc.dp.intf.service.mediator.StockingUco;

@Controller
public class MediatorController {
	@Autowired private StockingUco uco;
	
	@RequestMapping(value = "/md", method = RequestMethod.GET)
	public String index() {
		return "mdindex";
	}
	
	@RequestMapping(value = "/md/ord", method = RequestMethod.GET)
	public String order(Model model) {
		model.addAttribute("products", uco.getAllProducts());
		return "mdorder";
	}
	
	@RequestMapping(value = "/md/cq/{prodName}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Boolean trackOrderStatus(@PathVariable String prodName) {
		return uco.checkQunatity(prodName);
	}
	
	@RequestMapping(value = "/md/si", method = RequestMethod.GET)
	public String stockIn(Model model) {
		model.addAttribute("products", uco.getAllProducts());
		return "mdstockin";
	}
}
