package com.hsdc.dp.web.dto;

import java.io.Serializable;
import java.util.List;

public class SingleListResponse implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 3007369569253005266L;
	private List<String> results;
	public List<String> getResults() {
		return results;
	}
	public void setResults(List<String> results) {
		this.results = results;
	}
}
