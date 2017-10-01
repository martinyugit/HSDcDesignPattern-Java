package com.hsdc.dp.intf.service.templatemethod;

import java.util.List;

import com.hsdc.dp.intf.dto.templatemethod.PolicyTransaction;

public interface RetrievePolicyTransactionUco {
	public List<PolicyTransaction> getTransactionList(String classKey);
}
