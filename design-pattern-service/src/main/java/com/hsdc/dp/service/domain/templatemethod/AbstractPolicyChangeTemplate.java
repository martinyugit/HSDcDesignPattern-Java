package com.hsdc.dp.service.domain.templatemethod;

import java.util.ArrayList;
import java.util.List;

import com.hsdc.dp.intf.dto.templatemethod.Policy;
import com.hsdc.dp.intf.dto.templatemethod.PolicyTransaction;

abstract class AbstractPolicyChangeTemplate {
	public List<PolicyTransaction> getTransactionList()
    {
        List<PolicyTransaction> trans = new ArrayList<PolicyTransaction>();
        trans.add(new PolicyTransactionImpl(true, new ArrayList<Policy>()));
        trans.add(new PolicyTransactionImpl(false, new ArrayList<Policy>()));
        for (Policy p : Db.getInstance().getPolicies()) {
        	for (PolicyTransaction t : trans) {
        		if (t.getCanEdit() == canEdit(p))
        			t.getPolicies().add(p);
        	}
        }
        return trans;
    }

    protected abstract boolean canEdit(Policy p);
}
