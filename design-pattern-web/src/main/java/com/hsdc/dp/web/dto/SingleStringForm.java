package com.hsdc.dp.web.dto;

import java.io.Serializable;

public class SingleStringForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5074522377558724327L;
	
	private String custName;

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

}
