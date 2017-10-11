package com.hsdc.dp.intf.dto.factorymethod;

import java.io.Serializable;

public final class Supplier implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8057627406998316329L;
	private String supplierID;
	private String supplierName;
	private String supplierContactEmail;
	
	public Supplier(String supplierID, String supplierName, String supplierContactEmail) {
		super();
		this.supplierID = supplierID;
		this.supplierName = supplierName;
		this.supplierContactEmail = supplierContactEmail;
	}
	public String getSupplierID() {
		return supplierID;
	}
	public void setSupplierID(String supplierID) {
		this.supplierID = supplierID;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getSupplierContactEmail() {
		return supplierContactEmail;
	}
	public void setSupplierContactEmail(String supplierContactEmail) {
		this.supplierContactEmail = supplierContactEmail;
	}

}
