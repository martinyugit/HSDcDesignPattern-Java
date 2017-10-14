package com.hsdc.dp.service.domain.templatemethod;

import java.util.List;

import com.hsdc.dp.intf.dto.templatemethod.Policy;
import com.hsdc.dp.intf.dto.templatemethod.PolicyTransaction;

final class PolicyTransactionImpl implements PolicyTransaction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 740780985823154614L;
	private boolean canEdit;
	private List<Policy> policies;
	
	public PolicyTransactionImpl(boolean canEdit, List<Policy> policies) {
		this.canEdit = canEdit;
		this.policies = policies;
	}

	public boolean getCanEdit() {
		return this.canEdit;
	}

	public List<Policy> getPolicies() {
		return this.policies;
	}
	
	public void setPolicies(List<Policy> policies) {
		this.policies = policies;
	}

}
