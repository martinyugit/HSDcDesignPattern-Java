package com.hsdc.dp.intf.service.prototype;

import java.util.List;

import com.hsdc.dp.intf.domain.prototype.ShallowPrototype;
import com.hsdc.dp.intf.domain.prototype.PurchaseOrder;

public interface MaintainPurchaseUco {
	public List<PurchaseOrder> getPurchaseLists();
	public ShallowPrototype<PurchaseOrder> newPurchaseOrder();
	public List<PurchaseOrder> save(PurchaseOrder po);
}
