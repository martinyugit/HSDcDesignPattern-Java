package com.hsdc.dp.service.composite;

import java.util.List;

import com.hsdc.dp.intf.dto.composite.Employee;

final class OrganizationUnitLeaf extends OrganizationUnit {

	@Override
	public List<Employee> getAllEmployee() {
		return this.empList;
	}

}
