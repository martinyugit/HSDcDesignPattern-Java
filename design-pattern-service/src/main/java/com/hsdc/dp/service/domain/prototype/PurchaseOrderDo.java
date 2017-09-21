package com.hsdc.dp.service.domain.prototype;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import com.hsdc.dp.intf.domain.prototype.Prototype;
import com.hsdc.dp.intf.domain.prototype.PurchaseOrder;
import com.hsdc.dp.intf.domain.prototype.PurchaseOrderLineItem;

 class PurchaseOrderDo implements Prototype<PurchaseOrder>, PurchaseOrder {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3518991452979589166L;
	
	private String poNumber;
	private String customerName;
	private List<PurchaseOrderLineItem> items = null;
	
	private PurchaseOrderDo() {
		items = new ArrayList<PurchaseOrderLineItem>();
	}
	
	static PurchaseOrderDo createInstance() {
		return new PurchaseOrderDo();
	}
	
	void setPurchaseOrderLineItem(List<PurchaseOrderLineItem> items) {
		this.items = items;
	}

	public String getPoNumber() {
		return this.poNumber;
	}

	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public List<PurchaseOrderLineItem> getLineItems() {
		return this.items;
	}

	public void addLineItem(PurchaseOrderLineItem item) {
		this.items.add(item);
	}

	public BigDecimal getTotal() {
		BigDecimal subTotal = BigDecimal.ZERO;
        if (items == null)
            return subTotal;
        for (PurchaseOrderLineItem i : items)
        	subTotal = subTotal.add(i.getSubTotal());
        return subTotal.round(new MathContext(4, RoundingMode.HALF_UP));
	}

	public PurchaseOrder clone() {
		return new PurchaseOrderDo();
	}

}
