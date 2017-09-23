package com.hsdc.dp.intf.dto.bridge;

import java.util.HashMap;
import java.util.Map;

public enum OrderProgress {
	RECEIVE_ORDER(0, "收到訂單"),PICK_PRODUCT(1, "撿貨"), ARRANGE_PRODUCT(2, "理貨"), 
	SHIPPING(3, "出貨"), IN_SHIPMENT_STOCK(4, "宅配單位收貨"), IN_DELIVER_WAY(5, "宅配單位運送中"),
	DELIVERED(6, "到貨"), NONE(99, "無資料");
	private int key;
	private String value;
	
	private static Map<Integer, OrderProgress> keysToOrderProgress = new HashMap<Integer, OrderProgress>();
	static {
		for (OrderProgress o: OrderProgress.values()) keysToOrderProgress.put(o.key, o);
	}
	
	OrderProgress(int key, String value) {
		this.key = key;
		this.value = value;
	}
	
	public int getKey() {
		return this.key;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public static OrderProgress fromKey(int key) {
		OrderProgress target = keysToOrderProgress.get(key);
		if (target == null) throw new RuntimeException("No such key!");
		return target;
	}
}
