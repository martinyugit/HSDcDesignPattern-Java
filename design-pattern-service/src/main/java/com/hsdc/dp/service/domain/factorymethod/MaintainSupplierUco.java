package com.hsdc.dp.service.domain.factorymethod;

import java.util.List;

import com.hsdc.dp.intf.service.factorymethod.Supplier;

public class MaintainSupplierUco extends MaintainUcoCreator<Supplier> {

	@Override
	protected MaintainJobDao<Supplier> createMaintaionJob() {
		return new MaintainSupplierDao();
	}

	@Override
	protected List<Supplier> businessRuleCheck(List<Supplier> obj) {
		return obj;
	}

}
