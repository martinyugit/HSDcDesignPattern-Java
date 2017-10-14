package com.hsdc.dp.service.domain.templatemethod;

import com.hsdc.dp.intf.dto.templatemethod.Policy;

final class PolicyImpl implements Policy {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4828764817476154103L;
	
	private String policyNumber;
	private String policyName;
	private String policyOwnerName;
	private String policyInsuredName;
	private PolicyType policyType;
	
	

	public PolicyImpl(String policyNumber, String policyName, String policyOwnerName, String policyInsuredName,
			PolicyType policyType) {
		super();
		this.policyNumber = policyNumber;
		this.policyName = policyName;
		this.policyOwnerName = policyOwnerName;
		this.policyInsuredName = policyInsuredName;
		this.policyType = policyType;
	}

	public String getPolicyNumber() {
		return this.policyNumber;
	}

	public String getPolicyName() {
		return this.policyName;
	}

	public String getPolicyOwnerName() {
		return this.policyOwnerName;
	}

	public String getPolicyInsuredName() {
		return this.policyInsuredName;
	}

	public PolicyType getPolicyType() {
		return this.policyType;
	}

}
