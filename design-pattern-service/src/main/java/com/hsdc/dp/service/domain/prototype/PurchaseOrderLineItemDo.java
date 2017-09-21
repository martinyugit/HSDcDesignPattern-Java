package com.hsdc.dp.service.domain.prototype;

import java.math.BigDecimal;

import com.hsdc.dp.intf.domain.prototype.Prototype;
import com.hsdc.dp.intf.domain.prototype.PurchaseOrderLineItem;

 class PurchaseOrderLineItemDo implements Prototype<PurchaseOrderLineItem>, PurchaseOrderLineItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4770654177702063422L;
	
	private String productName;
	private int quantity;
	private BigDecimal price;
	
	private PurchaseOrderLineItemDo() {
	}
	
	static PurchaseOrderLineItemDo createInstance() {
		return new PurchaseOrderLineItemDo();
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getSubTotal() {
		return calculate();
	}

	public PurchaseOrderLineItem clone() {
		return new PurchaseOrderLineItemDo();
	}
	
	private BigDecimal calculate() {
		return this.price.multiply(new BigDecimal(quantity));
	}

}
