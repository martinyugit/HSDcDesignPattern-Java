package com.hsdc.dp.service.bridge;

import com.hsdc.dp.intf.dto.bridge.OrderProgress;

class BlackCatDeliveryProgressImpl extends InDeliveryProgressImpl {

	@Override
	protected String getProgress(String shippingId) {
		// 去黑貓宅急便取得狀態
        return simulateWebService(shippingId);
	}

	@Override
	protected OrderProgress transferToOrderProgress(String shippingStatus) {
		return shippingStatus.equals("已送達") ? OrderProgress.DELIVERED :
            (shippingStatus.equals("已收貨") ? OrderProgress.IN_SHIPMENT_STOCK : OrderProgress.IN_DELIVER_WAY);
	}
	
	private String simulateWebService(String shippingId)
    {
        long id = Long.parseLong(shippingId);
        int value = (int)(id % 3);
        return value == 0 ? "已收貨" : (value == 1 ? "送達衛星所" : (value == 2 ? "送貨中" : "已送達"));
    }

}
