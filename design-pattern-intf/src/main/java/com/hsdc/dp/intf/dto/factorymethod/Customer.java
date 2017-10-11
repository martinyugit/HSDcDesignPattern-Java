package com.hsdc.dp.intf.dto.factorymethod;

import java.io.Serializable;

public final class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6769591581233093071L;
	private String customerID;
	private String customerName;
	private String customerContactPerson;
	
	public Customer(String customerID, String customerName, String customerContactPerson) {
		super();
		this.customerID = customerID;
		this.customerName = customerName;
		this.customerContactPerson = customerContactPerson;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerContactPerson() {
		return customerContactPerson;
	}
	public void setCustomerContactPerson(String customerContactPerson) {
		this.customerContactPerson = customerContactPerson;
	}
}
