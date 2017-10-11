package com.hsdc.dp.service.domain.factorymethod;

import java.util.List;

import com.hsdc.dp.intf.service.factorymethod.Customer;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

class MaintainCustomerDao extends MaintainJobDao<Customer> {

	@Override
	public void create(Customer obj) {
		throw new NotImplementedException();
	}

	@Override
	public List<Customer> read() {
		return Db.getInstance().getCustomers();
	}

	@Override
	public void update(Customer obj) {
		throw new NotImplementedException();
	}

	@Override
	public void delete(Customer obj) {
		throw new NotImplementedException();
	}

}
