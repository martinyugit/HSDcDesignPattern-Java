package com.hsdc.dp.web.dto;

import java.io.Serializable;

public class SingletonStringResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3899088995857111495L;
	
	private String response;
	
	public SingletonStringResponse(String response) {
		this.response = response;
	}
	
	public String getResponse() {
		return this.response;
	}

}
