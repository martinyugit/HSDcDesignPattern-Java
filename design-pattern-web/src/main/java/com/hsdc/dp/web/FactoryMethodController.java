package com.hsdc.dp.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hsdc.dp.intf.service.factorymethod.Customer;
import com.hsdc.dp.intf.service.factorymethod.Product;
import com.hsdc.dp.intf.service.factorymethod.Supplier;
import com.hsdc.dp.service.domain.factorymethod.MaintainCustomerUco;
import com.hsdc.dp.service.domain.factorymethod.MaintainProductUco;
import com.hsdc.dp.service.domain.factorymethod.MaintainSupplierUco;
import com.hsdc.dp.service.domain.factorymethod.MaintainUcoCreator;

@Controller
public class FactoryMethodController {
	@RequestMapping(value = "/fm", method = RequestMethod.GET)
	public String index() {
		return "fmindex";
	}
	
	@RequestMapping(value = "/fm/cust", method = RequestMethod.GET)
	public String queryCustomers(Model model) {
		MaintainUcoCreator<Customer> uco = new MaintainCustomerUco();
        List<Customer> customers = uco.listAll();
        model.addAttribute("customers", customers);
		return "fmcustomer";
	}
	
	@RequestMapping(value = "/fm/cust/{customerID}", method = RequestMethod.GET)
	public String queryCustomer(@PathVariable String customerID, Model model) {
		return queryCustomers(model);
	}
	
	@RequestMapping(value = "/fm/cust/del/{customerID}", method = RequestMethod.GET)
	public String deleteCustomer(@PathVariable String customerID, Model model) {
		return queryCustomers(model);
	}
	
	@RequestMapping(value = "/fm/supp", method = RequestMethod.GET)
	public String querySuppliers(Model model) {
		MaintainUcoCreator<Supplier> uco = new MaintainSupplierUco();
        List<Supplier> suppliers = uco.listAll();
        model.addAttribute("suppliers", suppliers);
		return "fmsupplier";
	}
	
	@RequestMapping(value = "/fm/supp/{supplierID}", method = RequestMethod.GET)
	public String querySupplier(@PathVariable String supplierID, Model model) {
		return querySuppliers(model);
	}
	
	@RequestMapping(value = "/fm/supp/del/{supplierID}", method = RequestMethod.GET)
	public String deleteSupplier(@PathVariable String supplierID, Model model) {
		return querySuppliers(model);
	}
	
	@RequestMapping(value = "/fm/prod", method = RequestMethod.GET)
	public String queryProducts(Model model) {
		MaintainUcoCreator<Product> uco = new MaintainProductUco();
        List<Product> products = uco.listAll();
        model.addAttribute("products", products);
		return "fmproduct";
	}
	
	@RequestMapping(value = "/fm/prod/{productID}", method = RequestMethod.GET)
	public String queryProduct(@PathVariable String productID, Model model) {
		return queryProducts(model);
	}
	
	@RequestMapping(value = "/fm/prod/del/{productID}", method = RequestMethod.GET)
	public String deleteProduct(@PathVariable String productID, Model model) {
		return queryProducts(model);
	}
}
