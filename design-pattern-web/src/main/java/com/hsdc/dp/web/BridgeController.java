package com.hsdc.dp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hsdc.dp.intf.service.bridge.QueryOrderProgressUco;
import com.hsdc.dp.web.dto.SingleStringResponse;

@Controller
public class BridgeController {
	@RequestMapping(value = "/bg", method = RequestMethod.GET)
	public String index(Model model) {
		return "bgindex";
	}
	
	@Autowired private QueryOrderProgressUco uco;
	@RequestMapping(value = "/bg/qo/{orderId}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody SingleStringResponse trackOrderStatus(@PathVariable String orderId) {
		SingleStringResponse response = new SingleStringResponse();
		response.setResult(uco.Query(orderId));
		return response;
	}
}
