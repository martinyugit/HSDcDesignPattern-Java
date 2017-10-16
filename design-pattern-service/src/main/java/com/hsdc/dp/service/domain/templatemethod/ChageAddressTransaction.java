package com.hsdc.dp.service.domain.templatemethod;

import com.hsdc.dp.intf.dto.templatemethod.Policy;

public class ChageAddressTransaction extends AbstractPolicyChangeTemplate {

	@Override
	protected boolean canEdit(Policy p) {
		return true;
	}

}
