package com.hsdc.dp.service.domain.factorymethod;

import java.util.List;

import com.hsdc.dp.intf.service.factorymethod.Customer;

public class MaintainCustomerUco extends MaintainUcoCreator<Customer> {

	@Override
	protected MaintainJobDao<Customer> createMaintaionJob() {
		return new MaintainCustomerDao();
	}

	@Override
	protected List<Customer> businessRuleCheck(List<Customer> obj) {
		return obj;
	}

}
