package com.hsdc.dp.service.domain.mediator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hsdc.dp.intf.dto.mediator.Product;
import com.hsdc.dp.intf.dto.mediator.Stocking;
import com.hsdc.dp.intf.service.mediator.StockingUco;

@Service
public class StockingUcoImpl implements StockingUco {

	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<Product>();
		for (Stocking s : Db.getInstance().getStocking()) {
			products.add(s.getProduct());
		}
		return products;
	}

	public boolean checkQunatity(String prodName) {
		for (Stocking s : Db.getInstance().getStocking()) {
			if (s.getProduct().getProductName().equals(prodName)) {
				return s.getQuantity() == 0;
			}
		}
		return false;
	}

}
