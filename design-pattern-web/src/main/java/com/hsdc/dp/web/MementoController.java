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
@SessionScope
public class MementoController {
	
	@RequestMapping(value = "/mem", method = RequestMethod.GET)
	public String index(Model model) {
		return "memindex";
	}
	
	@Autowired private LottoUco uco;
	@RequestMapping(value = "/mem/computerSelNum", method = RequestMethod.GET, produces="text/html;charset=UTF-8")
	public @ResponseBody String computerSelNum() {
		return uco.computerSelNum();
	}

	@RequestMapping(value = "/mem/list", method = RequestMethod.GET, produces="text/html;charset=UTF-8")
	public @ResponseBody String list() {
		return uco.getList();
	}
	
	@RequestMapping(value = "/mem/append", method = RequestMethod.GET, produces="text/html;charset=UTF-8")
	public void append(@RequestParam(value="inputNum") String string) {
		System.out.println(string);
		uco.doAppend(string);
	}

	@RequestMapping(value = "/mem/delete", method = RequestMethod.GET, produces="text/html;charset=UTF-8")
	public void delete(@RequestParam(value="inputIdx") int idx) {
		uco.doDelete(idx);
	}
	
	@RequestMapping(value = "/mem/restore", method = RequestMethod.GET, produces="text/html;charset=UTF-8")
	public  @ResponseBody String restore(@RequestParam(value="inputIdx") int idx) {
		return uco.doRestore(idx);
	}

	@RequestMapping(value = "/mem/update", method = RequestMethod.GET, produces="text/html;charset=UTF-8")
	public void update(@RequestParam(value="inputIdx") int idx, @RequestParam(value="inputNum") String num) {
		uco.doUpdate(idx, num);
	}

}
