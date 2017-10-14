package com.hsdc.dp.intf.dto.mediator;

import java.io.Serializable;

public class Stocking implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5697429746095862152L;
	
	private int quantity;
	private Product product;
	public Stocking(int quantity, Product product) {
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
