package com.hsdc.dp.intf.dto.mediator;

import java.io.Serializable;

public class StockIn implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7776504293916489603L;
	
	private int quantity;
	private Product product;
	
	public StockIn(int quantity, Product product) {
		super();
		this.quantity = quantity;
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}

}
