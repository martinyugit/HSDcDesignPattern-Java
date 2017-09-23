package com.hsdc.dp.service.bridge;

import com.hsdc.dp.intf.domain.bridge.StatusProgressImpl;
import com.hsdc.dp.intf.dto.bridge.OrderProgress;

class InStockStatusProgressImpl implements StatusProgressImpl {

	public OrderProgress getCurrentOrderProgress(String oid) {
		int value = QueryOrderDao.RealOrderStatus(oid);
        return OrderProgress.fromKey(value);
	}

}
