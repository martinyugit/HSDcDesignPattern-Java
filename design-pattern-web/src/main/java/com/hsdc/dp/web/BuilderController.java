package com.hsdc.dp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hsdc.dp.intf.dto.builder.ApplyExpense;
import com.hsdc.dp.intf.dto.builder.Leave;
import com.hsdc.dp.intf.service.builder.EOfficeDirector;
import com.hsdc.dp.intf.service.builder.SaveEOfficeUco;
import com.hsdc.dp.service.builder.ApplyExpenseBuilder;
import com.hsdc.dp.service.builder.EOfficeDirectorImpl;
import com.hsdc.dp.service.builder.LeaveBuilder;

@Controller
public class BuilderController {
	@RequestMapping(value = "/bd", method = RequestMethod.GET)
	public String index(Model model) {
		return "bdindex";
	}
	
	@RequestMapping(value = "/bd/nlv", method = RequestMethod.GET)
	public String newLeave(Model model) {
		LeaveBuilder leave = new LeaveBuilder();
		EOfficeDirector<Leave> director = new EOfficeDirectorImpl<Leave>();
		Leave form = director.construct(leave);
		model.addAttribute("form", form);
		return "newleave";
	}
	
	@Autowired @Qualifier("saveLeaveUcoImpl") private SaveEOfficeUco<Leave> leaveUco;
	@RequestMapping(value = "/bd/nlv", method = RequestMethod.POST)
	public String saveLeave(@ModelAttribute("form")Leave leave, Model model) {
		leave = leaveUco.save(leave);
		model.addAttribute("o", leave);
		return "leaveresult";
	}
	
	@RequestMapping(value = "/bd/nae", method = RequestMethod.GET)
	public String newApplyExpense(Model model) {
		ApplyExpenseBuilder ae = new ApplyExpenseBuilder();
		EOfficeDirector<ApplyExpense> director = new EOfficeDirectorImpl<ApplyExpense>();
		ApplyExpense form = director.construct(ae);
		model.addAttribute("form", form);
		return "newapplyexp";
	}
}
