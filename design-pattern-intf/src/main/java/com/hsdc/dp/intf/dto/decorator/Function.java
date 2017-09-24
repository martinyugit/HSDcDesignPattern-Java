package com.hsdc.dp.intf.dto.decorator;

import java.io.Serializable;

public class Function implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6472555187209442773L;
	
	private String functionName;
    private String functionUrl;
    
	public Function(String functionName, String functionUrl) {
		super();
		this.functionName = functionName;
		this.functionUrl = functionUrl;
	}
	public String getFunctionName() {
		return functionName;
	}
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}
	public String getFunctionUrl() {
		return functionUrl;
	}
	public void setFunctionUrl(String functionUrl) {
		this.functionUrl = functionUrl;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((functionName == null) ? 0 : functionName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Function other = (Function) obj;
		if (functionName == null) {
			if (other.functionName != null)
				return false;
		} else if (!functionName.equals(other.functionName))
			return false;
		return true;
	}
}
