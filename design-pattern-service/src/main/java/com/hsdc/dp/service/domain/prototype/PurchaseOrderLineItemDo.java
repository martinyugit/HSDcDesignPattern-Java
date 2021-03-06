package com.hsdc.dp.service.domain.prototype;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import java.math.BigDecimal;

import com.hsdc.dp.intf.domain.prototype.ShallowPrototype;
import com.hsdc.dp.intf.domain.prototype.PurchaseOrderLineItem;

 class PurchaseOrderLineItemDo implements Cloneable, ShallowPrototype<PurchaseOrderLineItem>, PurchaseOrderLineItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4770654177702063422L;

	private static final Object lock = new Object();
	private static volatile PurchaseOrderLineItemDo instance;

	private String productName;
	private int quantity;
	private BigDecimal price;
	
	private PurchaseOrderLineItemDo() {
	}
	
	private static PurchaseOrderLineItemDo getInstance() {
		PurchaseOrderLineItemDo r = instance;
	    if (r == null) {
	        synchronized (lock) {    // While we were waiting for the lock, another 
	            r = instance;        // thread may have instantiated the object.
	            if (r == null) {  
	                r = new PurchaseOrderLineItemDo();
	                instance = r;
	            }
	        }
	    }
	    return r;
	}

	static PurchaseOrderLineItemDo createInstance() {
		return getInstance().shallowClone();// new PurchaseOrderLineItemDo();
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

	public PurchaseOrderLineItemDo shallowClone() {
		try {
			return (PurchaseOrderLineItemDo) this.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private BigDecimal calculate() {
		return this.price.multiply(new BigDecimal(quantity));
	}

}
