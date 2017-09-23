package com.hsdc.dp.service.bridge;

import org.springframework.stereotype.Service;

import com.hsdc.dp.intf.domain.bridge.StatusProgressImpl;
import com.hsdc.dp.intf.dto.bridge.Order;
import com.hsdc.dp.intf.dto.bridge.OrderProgress;
import com.hsdc.dp.intf.dto.bridge.OrderStatus;
import com.hsdc.dp.intf.service.bridge.QueryOrderProgressUco;

@Service
public class QueryOrderProgressUcoImpl implements QueryOrderProgressUco {
	private StatusProgressImpl implementor;

	public String Query(String orderID) {
		OrderProgress progress = OrderProgress.NONE;
        Order order = QueryOrderDao.QueryOrder(orderID);
        if (order == null)
            return progress.getValue();
        ProcessStatusProgressImpl(order.getOrderStatus(), order.getShipper());
        progress = implementor.getCurrentOrderProgress(orderID);
        return progress.getValue();
	}
	
	private void ProcessStatusProgressImpl(OrderStatus status, String shipper) {
		switch (status) {
			case IN_STOCK:
				this.implementor = new InStockStatusProgressImpl();
				break;
			case SHIPPING:
				if (shipper.equals("BlackCat"))
					this.implementor = new BlackCatDeliveryProgressImpl();
				else
					this.implementor = new PostOfficeDeliveryProgressImpl();
				break;
			default:
				break;
		}
	}
}
