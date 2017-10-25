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

import com.hsdc.dp.intf.service.adapter.AdapterUco;
import com.hsdc.dp.intf.service.memento.LottoUco;
import com.hsdc.dp.intf.service.visitor.VisitorUco;

@Controller
public class AdapterController {
	
	@RequestMapping(value = "/ad", method = RequestMethod.GET)
	public String index(Model model) {
		return "adindex";
	}
	
	@Autowired private AdapterUco uco;
	@RequestMapping(value = "/ad/execute", method = RequestMethod.GET, produces="text/html;charset=UTF-8")
	public @ResponseBody String execute(@RequestParam(value="x1") int x1, @RequestParam(value="x2") int x2, @RequestParam(value="y1") int y1, @RequestParam(value="y2") int y2) {
		System.out.println("-----------------------------------------------");
		uco.draw(x1, x2, y1, y2);
		return "on console...";
	}
}
