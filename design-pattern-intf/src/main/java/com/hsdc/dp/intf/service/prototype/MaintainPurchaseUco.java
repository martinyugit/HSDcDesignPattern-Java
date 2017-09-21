package com.hsdc.dp.intf.service.prototype;

import java.util.List;

import com.hsdc.dp.intf.domain.prototype.Prototype;
import com.hsdc.dp.intf.domain.prototype.PurchaseOrder;

public interface MaintainPurchaseUco {
	public List<PurchaseOrder> getPurchaseLists();
	public Prototype<PurchaseOrder> newPurchaseOrder();
	public List<PurchaseOrder> save(PurchaseOrder po);
}
