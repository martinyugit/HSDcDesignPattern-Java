package com.hsdc.dp.intf.service.factorymethod;

import java.io.Serializable;

public class Supplier implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5245066024421061967L;
	
	private String supplierNumber;
	private String supplierName;
	private String supplierContactEmail;
	
	public Supplier(String supplierNumber, String supplierName, String supplierContactEmail) {
		super();
		this.supplierNumber = supplierNumber;
		this.supplierName = supplierName;
		this.supplierContactEmail = supplierContactEmail;
	}
	public String getSupplierNumber() {
		return supplierNumber;
	}
	public void setSupplierNumber(String supplierNumber) {
		this.supplierNumber = supplierNumber;
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
