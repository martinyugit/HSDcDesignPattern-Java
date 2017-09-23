package com.hsdc.dp.service.bridge;

import com.hsdc.dp.intf.domain.bridge.StatusProgressImpl;
import com.hsdc.dp.intf.dto.bridge.OrderProgress;

abstract class InDeliveryProgressImpl implements StatusProgressImpl {

	public OrderProgress getCurrentOrderProgress(String oid) {
		String progress = getProgress(getShippingID(oid));
        return transferToOrderProgress(progress);
	}
	
	private String getShippingID(String oid)
    {
        return QueryOrderDao.QueryOrder(oid).getShippingID();
    }
	
	protected abstract String getProgress(String shippingId);
    protected abstract OrderProgress transferToOrderProgress(String shippingStatus);
}
