package com.hsdc.dp.web.dto;

import java.io.Serializable;

public class SingleStringResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5060064155021752932L;
	private String result;
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
}
