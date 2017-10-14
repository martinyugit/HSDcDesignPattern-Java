package com.hsdc.dp.service.domain.factorymethod;

import java.util.List;

import com.hsdc.dp.intf.service.factorymethod.Supplier;

class MaintainSupplierDao extends MaintainJobDao<Supplier> {

	@Override
	public void create(Supplier obj) {
		throw new RuntimeException("Not implemented");
	}

	@Override
	public List<Supplier> read() {
		return Db.getInstance().getSuppliers();
	}

	@Override
	public void update(Supplier obj) {
		throw new RuntimeException("Not implemented");
	}

	@Override
	public void delete(Supplier obj) {
		throw new RuntimeException("Not implemented");
	}

}
