package com.hsdc.dp.service.singleton;

import java.io.Serializable;

public class Form implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1377426515579565003L;

	private String formType;
	private String formDateStr;
	
	public String getFormType() {
		return formType;
	}
	public void setFormType(String formType) {
		this.formType = formType;
	}
	public String getFormDateStr() {
		return formDateStr;
	}
	public void setFormDateStr(String formDateStr) {
		this.formDateStr = formDateStr;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((formDateStr == null) ? 0 : formDateStr.hashCode());
		result = prime * result + ((formType == null) ? 0 : formType.hashCode());
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
		Form other = (Form) obj;
		if (formDateStr == null) {
			if (other.formDateStr != null)
				return false;
		} else if (!formDateStr.equals(other.formDateStr))
			return false;
		if (formType == null) {
			if (other.formType != null)
				return false;
		} else if (!formType.equals(other.formType))
			return false;
		return true;
	}	
	
}
