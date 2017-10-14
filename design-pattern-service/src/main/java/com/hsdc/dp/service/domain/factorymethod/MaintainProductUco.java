package com.hsdc.dp.service.domain.factorymethod;

import java.util.ArrayList;
import java.util.List;

import com.hsdc.dp.intf.service.factorymethod.Product;

public class MaintainProductUco extends MaintainUcoCreator<Product> {

	@Override
	protected MaintainJobDao<Product> createMaintaionJob() {
		return new MaintainProductDao();
	}

	@Override
	protected List<Product> businessRuleCheck(List<Product> obj) {
		List<Product> returnVal = new ArrayList<Product>();
		for (Product p : obj) {
			if (p.getIsDelete())
				continue;
			returnVal.add(p);
		}
		return returnVal;
	}

}
