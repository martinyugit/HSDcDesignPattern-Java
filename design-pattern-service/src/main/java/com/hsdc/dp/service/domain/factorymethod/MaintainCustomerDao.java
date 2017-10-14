package com.hsdc.dp.service.domain.factorymethod;

import java.util.List;

import com.hsdc.dp.intf.service.factorymethod.Customer;

class MaintainCustomerDao extends MaintainJobDao<Customer> {

	@Override
	public void create(Customer obj) {
		throw new RuntimeException("Not implemented");
	}

	@Override
	public List<Customer> read() {
		return Db.getInstance().getCustomers();
	}

	@Override
	public void update(Customer obj) {
		throw new RuntimeException("Not implemented");
	}

	@Override
	public void delete(Customer obj) {
		throw new RuntimeException("Not implemented");
	}

}
