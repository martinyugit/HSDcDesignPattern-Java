package com.hsdc.dp.intf.domain.prototype;

import java.io.Serializable;
import java.math.BigDecimal;

public interface PurchaseOrderLineItem extends Serializable {
	String getProductName();
	void setProductName(String productName);
    int getQuantity();
    void setQuantity(int quantity);
    BigDecimal getPrice();
    void setPrice(BigDecimal price);
    BigDecimal getSubTotal();
}
