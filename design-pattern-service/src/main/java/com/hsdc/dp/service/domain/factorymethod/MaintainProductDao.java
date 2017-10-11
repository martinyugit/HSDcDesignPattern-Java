package com.hsdc.dp.service.domain.factorymethod;

import java.util.List;

import com.hsdc.dp.intf.service.factorymethod.Product;

class MaintainProductDao extends MaintainJobDao<Product> {

	@Override
	public void create(Product obj) {
		throw new RuntimeException("Not implemented");
	}

	@Override
	public List<Product> read() {
		return Db.getInstance().getProducts();
	}

	@Override
	public void update(Product obj) {
		throw new RuntimeException("Not implemented");
	}

	@Override
	public void delete(Product obj) {
		throw new RuntimeException("Not implemented");
	}

}
