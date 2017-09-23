package com.hsdc.dp.service.composite;

import java.util.ArrayList;
import java.util.List;

import com.hsdc.dp.intf.dto.composite.Employee;

final class OrganizationUnitComposite extends OrganizationUnit {
	 private List<OrganizationUnit> children;

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> allEmp = new ArrayList<Employee>();
        allEmp.addAll(this.empList);
        for (OrganizationUnit g : children)
            allEmp.addAll(g.getAllEmployee());
        return allEmp;
	}
	
	@Override
	public void add(OrganizationUnit child) {
		if (children == null)
            children = new ArrayList<OrganizationUnit>();
        children.add(child);
	}
	
	@Override
	public void remove(OrganizationUnit child) {
		if (children == null)
            return;
        children.remove(child);
	}
	
	@Override
	public OrganizationUnit getChild(int index) {
		if (children == null)
            return null;
        return children.get(index);
	}
	
	@Override
	public List<OrganizationUnit> getChildren() {
		List<OrganizationUnit> orgs = new ArrayList<OrganizationUnit>();
        orgs.addAll(children);
        for (OrganizationUnit child : children)
            orgs.addAll(child.getChildren());
        return orgs;
	}
	
	@Override
	public OrganizationUnit getUnit(String deptName) {
		OrganizationUnit ou = super.getUnit(deptName);
        if (ou != null)
            return ou;
        for (OrganizationUnit g : children)
        {
            ou = g.getUnit(deptName);
            if (ou != null)
                return ou;
        }
        return ou;
	}
}
