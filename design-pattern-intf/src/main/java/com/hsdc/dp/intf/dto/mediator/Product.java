package com.hsdc.dp.intf.dto.mediator;

import java.io.Serializable;

public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8332778747928705942L;
	
	private String productName;

	public Product(String productName) {
		super();
		this.productName = productName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

}
