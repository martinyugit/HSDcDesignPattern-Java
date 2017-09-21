package com.hsdc.dp.service.domain.prototype;

import java.math.BigDecimal;

import com.hsdc.dp.intf.domain.prototype.DeepPrototype;
import com.hsdc.dp.intf.domain.prototype.PurchaseOrderLineItem;

 class PurchaseOrderLineItemErpDo implements DeepPrototype<PurchaseOrderLineItem>, PurchaseOrderLineItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4770654177702063422L;
	
	private String productName;
	private int quantity;
	private BigDecimal price;
	
	private PurchaseOrderLineItemErpDo() {
	}
	
	static PurchaseOrderLineItemErpDo createInstance() {
		return new PurchaseOrderLineItemErpDo();
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
	
	private BigDecimal calculate() {
		return this.price.multiply(new BigDecimal(quantity));
	}

	public PurchaseOrderLineItem cloneDeep() {
		return (PurchaseOrderLineItem)clone();
	}
	
	@Override
	public Object clone() {
		PurchaseOrderLineItem newItem = new PurchaseOrderLineItemErpDo();
		newItem.setProductName(this.productName);
		newItem.setPrice(this.price);
		newItem.setQuantity(this.quantity);
		return newItem;
	}

}
