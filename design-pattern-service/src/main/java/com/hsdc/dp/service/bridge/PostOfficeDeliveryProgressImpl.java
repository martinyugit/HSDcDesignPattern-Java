package com.hsdc.dp.service.bridge;

import com.hsdc.dp.intf.dto.bridge.OrderProgress;

class PostOfficeDeliveryProgressImpl extends InDeliveryProgressImpl {

	@Override
	protected String getProgress(String shippingId) {
		// 去郵局取得狀態
        return simulateWebService(shippingId);
	}

	@Override
	protected OrderProgress transferToOrderProgress(String shippingStatus) {
		return shippingStatus.equals("郵件已送達") ? OrderProgress.DELIVERED :
            (shippingStatus.contains("已收貨") ? OrderProgress.IN_SHIPMENT_STOCK : OrderProgress.IN_DELIVER_WAY);
	}
	
	private String simulateWebService(String shippingId)
    {
        long id = Long.parseLong(shippingId);
        int value = (int)(id % 2);
        return value == 0 ? "xx郵局已收貨" : (value == 1 ? "郵件投遞中" : "郵件已送達");
    }

}
