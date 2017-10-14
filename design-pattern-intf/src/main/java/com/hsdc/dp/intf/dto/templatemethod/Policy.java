package com.hsdc.dp.intf.dto.templatemethod;

import java.io.Serializable;

public interface Policy extends Serializable {
	public enum PolicyType {
		NORMAL(0, "正常"), IN_APPROVE(1, "審核中"), HAS_CLAIMED(2, "已理賠"),;
		
		private int key;
		private String value;
		
		PolicyType(int key, String value) {
			this.key = key;
			this.value = value;
		}
		
		public int getKey() {
			return this.key;
		}
		
		public String getValue() {
			return this.value;
		}
	}
	
	public String getPolicyNumber();
    public String getPolicyName();
    public String getPolicyOwnerName();
    public String getPolicyInsuredName();
    public PolicyType getPolicyType();
}
