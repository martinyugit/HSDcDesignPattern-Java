package com.hsdc.dp.intf.service.factorymethod;

import java.io.Serializable;
import java.math.BigDecimal;

public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5497929260613362445L;
	
	private String productID;
	private String productName;
	private String productType;
	private BigDecimal productMSRP;
	private boolean isDelete;
	
	public Product(String productID, String productName, String productType, BigDecimal productMSRP, boolean isDelete) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.productType = productType;
		this.productMSRP = productMSRP;
		this.isDelete = isDelete;
	}
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public BigDecimal getProductMSRP() {
		return productMSRP;
	}
	public void setProductMSRP(BigDecimal productMSRP) {
		this.productMSRP = productMSRP;
	}
	public boolean getIsDelete() {
		return isDelete;
	}
	public void seIstDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	
}
