package com.hsdc.dp.intf.dto.bridge;

import java.io.Serializable;

public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3130973545711182385L;
	
	private String orderID;
	private String productName;
	private OrderStatus orderStatus;
	private String shipper;
	private String shippingID;
	
	public Order(String orderID, OrderStatus orderStatus, String productName, String shipper, String shippingID) {
		super();
		this.orderID = orderID;
		this.productName = productName;
		this.orderStatus = orderStatus;
		this.shipper = shipper;
		this.shippingID = shippingID;
	}
	
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getShipper() {
		return shipper;
	}
	public void setShipper(String shipper) {
		this.shipper = shipper;
	}
	public String getShippingID() {
		return shippingID;
	}
	public void setShippingID(String shippingID) {
		this.shippingID = shippingID;
	}
}
