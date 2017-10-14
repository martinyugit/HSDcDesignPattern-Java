package com.hsdc.dp.service.domain.templatemethod;

import com.hsdc.dp.intf.dto.templatemethod.Policy;
import com.hsdc.dp.intf.dto.templatemethod.Policy.PolicyType;

public class PolicyLoanTransction extends AbstractPolicyChangeTemplate {

	@Override
	protected boolean canEdit(Policy p) {
		return p.getPolicyType() == PolicyType.NORMAL;
	}

}
