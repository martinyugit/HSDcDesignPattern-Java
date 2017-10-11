package com.hsdc.dp.service.domain.factorymethod;

import java.util.List;

import com.hsdc.dp.intf.service.factorymethod.Product;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

class MaintainProductDao extends MaintainJobDao<Product> {

	@Override
	public void create(Product obj) {
		throw new NotImplementedException();
	}

	@Override
	public List<Product> read() {
		return Db.getInstance().getProducts();
	}

	@Override
	public void update(Product obj) {
		throw new NotImplementedException();
	}

	@Override
	public void delete(Product obj) {
		throw new NotImplementedException();
	}

}
