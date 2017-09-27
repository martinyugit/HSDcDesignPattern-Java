package com.hsdc.dp.service.domain.prototype;

import java.math.BigDecimal;

import com.hsdc.dp.intf.domain.prototype.DeepPrototype;
import com.hsdc.dp.intf.domain.prototype.PurchaseOrderLineItem;

 class PurchaseOrderLineItemErpDo implements Cloneable, DeepPrototype<PurchaseOrderLineItem>, PurchaseOrderLineItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4770654177702063422L;

	private static final Object lock = new Object();
	private static volatile PurchaseOrderLineItemErpDo instance;
	
	private String productName;
	private int quantity;
	private BigDecimal price;
	
	private PurchaseOrderLineItemErpDo() {
	}

	private static PurchaseOrderLineItemErpDo getInstance() {
		PurchaseOrderLineItemErpDo r = instance;
	    if (r == null) {
	        synchronized (lock) {    // While we were waiting for the lock, another 
	            r = instance;        // thread may have instantiated the object.
	            if (r == null) {  
	                r = new PurchaseOrderLineItemErpDo();
	                instance = r;
	            }
	        }
	    }
	    return r;
	}
	
	static PurchaseOrderLineItemErpDo createInstance() {
		return getInstance().deepClone();
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

	public PurchaseOrderLineItemErpDo deepClone() {
		PurchaseOrderLineItemErpDo newItem;
		try {
			newItem = (PurchaseOrderLineItemErpDo) this.clone();
			newItem.setProductName(this.productName);
			newItem.setPrice(this.price);
			newItem.setQuantity(this.quantity);
			return newItem;
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
