package com.hsdc.dp.intf.service.mediator;

import java.util.List;

import com.hsdc.dp.intf.dto.mediator.Product;

public interface StockingUco {
	List<Product> getAllProducts();
	boolean checkQunatity(String prodName);
}
