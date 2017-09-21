package com.hsdc.dp.intf.domain.prototype;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public interface PurchaseOrder extends Serializable {
	String getPoNumber();
	void setPoNumber(String poNumber);
    String getCustomerName();
    void setCustomerName(String customerName);
    List<PurchaseOrderLineItem> getLineItems();
    void addLineItem(PurchaseOrderLineItem item);
    BigDecimal getTotal();
}
