package com.hsdc.dp.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hsdc.dp.intf.service.factorymethod.Customer;
import com.hsdc.dp.service.domain.factorymethod.MaintainCustomerUco;

@Controller
public class FactoryMethodController {
	@RequestMapping(value = "/fm", method = RequestMethod.GET)
	public String index() {
		return "fmindex";
	}
	
	@RequestMapping(value = "/fm/cust", method = RequestMethod.GET)
	public String queryCustomer(Model model) {
		MaintainCustomerUco uco = new MaintainCustomerUco();
        List<Customer> customers = uco.listAll();
        model.addAttribute("customers", customers);
		return "fmcustomer";
	}
}
