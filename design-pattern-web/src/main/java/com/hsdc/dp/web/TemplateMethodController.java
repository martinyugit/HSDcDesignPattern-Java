package com.hsdc.dp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hsdc.dp.intf.dto.templatemethod.PolicyTransaction;
import com.hsdc.dp.intf.service.templatemethod.RetrievePolicyTransactionUco;

@Controller
public class TemplateMethodController {
	@RequestMapping(value = "/tm", method = RequestMethod.GET)
	public String index() {
		return "tmindex";
	}
	
	@Autowired private RetrievePolicyTransactionUco uco;
	@RequestMapping(value = "/tm/qt/{classKey}", method = RequestMethod.GET)
	public @ResponseBody List<PolicyTransaction> query(@PathVariable String classKey) {
		return uco.getTransactionList(classKey);
	}
}
