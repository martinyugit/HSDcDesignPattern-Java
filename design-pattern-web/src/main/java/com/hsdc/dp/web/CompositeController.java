package com.hsdc.dp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hsdc.dp.intf.service.composite.ManageRingelOrgUco;
import com.hsdc.dp.web.dto.SingleListResponse;

@Controller
public class CompositeController {
	@Autowired private ManageRingelOrgUco uco;
	@RequestMapping(value = "/cp", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("depts", uco.getAllDepartmentName());
		return "cpindex";
	}
	
	@RequestMapping(value = "/cp/qe/{deptName}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody SingleListResponse queryEmployee(@PathVariable String deptName) {
		SingleListResponse response = new SingleListResponse();
		response.setResults(uco.getAllEmployeeName(deptName));
		return response;
	}
}
