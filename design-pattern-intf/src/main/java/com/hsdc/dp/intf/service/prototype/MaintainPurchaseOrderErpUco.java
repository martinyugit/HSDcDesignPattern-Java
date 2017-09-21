package com.hsdc.dp.intf.service.prototype;

import java.util.List;

import com.hsdc.dp.intf.domain.prototype.PurchaseOrder;

public interface MaintainPurchaseOrderErpUco {
	public List<PurchaseOrder> getPurchaseLists();
	public PurchaseOrder copyPo(String sourcePoNumber);
	public List<PurchaseOrder> save(PurchaseOrder po);
}
