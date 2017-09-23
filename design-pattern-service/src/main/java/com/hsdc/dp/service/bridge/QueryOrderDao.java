package com.hsdc.dp.service.bridge;

import java.util.HashMap;
import java.util.Map;

import com.hsdc.dp.intf.dto.bridge.Order;
import com.hsdc.dp.intf.dto.bridge.OrderStatus;

public class QueryOrderDao {
	public static Order QueryOrder(String oid)
    {
        return OrderData().get(oid);
    }
	
	public static int RealOrderStatus(String oid)
    {
        long id = Long.parseLong(oid.substring(3));
        int value = (int)(id % 3);
        return value;
    }
	
	private static Map<String, Order> OrderData()
    {
        Map<String, Order> orders = new HashMap<String, Order>();
        orders.put("ORD1411140001", new Order("ORD1411140001", OrderStatus.IN_STOCK, "Mac Book Pro", null, null ));
        orders.put("ORD1411140002", new Order("ORD1411140002", OrderStatus.SHIPPING, "ThunderBold Line", "BlackCat", "1" ));
        orders.put("ORD1411140003", new Order("ORD1411140003", OrderStatus.SHIPPING, "Design Pattern", "PostOffice", "2"));
        return orders;
    }
}
