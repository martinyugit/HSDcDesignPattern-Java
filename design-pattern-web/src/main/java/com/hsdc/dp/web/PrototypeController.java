package com.hsdc.dp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hsdc.dp.intf.domain.prototype.PurchaseOrder;
import com.hsdc.dp.intf.service.prototype.MaintainPurchaseOrderErpUco;
import com.hsdc.dp.intf.service.prototype.MaintainPurchaseUco;
import com.hsdc.dp.web.dto.SingleStringForm;

@Controller
public class PrototypeController {
	@RequestMapping(value = "/pt", method = RequestMethod.GET)
	public String index(Model model) {
		return "ptindex";
	}
	
	@Autowired private MaintainPurchaseUco muco;
	@RequestMapping(value="/pt/rf", method = RequestMethod.GET)
	public String ringleFramework(Model model) {
		model.addAttribute("polist", muco.getPurchaseLists());
		return "rflist";
	}
	
	@RequestMapping(value="/pt/rfa", method = RequestMethod.GET)
	public String ringleFrameworkAdd() {
		return "rfadd";
	}
	
	@RequestMapping(value="/pt/rfa", method = RequestMethod.POST)
	public String save(@ModelAttribute("form")SingleStringForm form, Model model) {
		PurchaseOrder newPo = muco.newPurchaseOrder().clone();
		newPo.setCustomerName(form.getCustName());
		model.addAttribute("polist", muco.save(newPo));
		return "rflist";
	}
	
	@Autowired private MaintainPurchaseOrderErpUco meuco;
	@RequestMapping(value="/pt/rerp", method = RequestMethod.GET)
	public String ringleErp(Model model) {
		model.addAttribute("polist", meuco.getPurchaseLists());
		return "relist";
	}
	
	@RequestMapping(value="/pt/rec/{poNumber}", method = RequestMethod.GET)
	public String ringleErpCopy(@PathVariable String poNumber, Model model) {
		model.addAttribute("po", meuco.copyPo(poNumber));
		return "recpy";
	}
	
	@RequestMapping(value="/pt/rec/{poNumber}", method = RequestMethod.POST)
	public String saveRep(@PathVariable String poNumber, @ModelAttribute("form")SingleStringForm form, Model model) {
		PurchaseOrder po = meuco.copyPo(poNumber);
		po.setCustomerName(form.getCustName());
		model.addAttribute("polist", meuco.save(po));
		return "relist";
	}
}
