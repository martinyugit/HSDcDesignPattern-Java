package com.hsdc.dp.service.composite;

import java.util.ArrayList;
import java.util.List;

import com.hsdc.dp.intf.dto.composite.Employee;

abstract class OrganizationUnit {
	private String departmentName;
	protected List<Employee> empList;
	public abstract List<Employee> getAllEmployee();
	
	public List<OrganizationUnit> getChildren()
    {
        return new ArrayList<OrganizationUnit>();
    }
	public void add(OrganizationUnit child)
    {
    }
    public void remove(OrganizationUnit child)
    {
    }
    public OrganizationUnit getChild(int index)
    {
        return null;
    }
    public void addEmployee(Employee emp)
    {
        if (empList == null)
            empList = new ArrayList<Employee>();
        empList.add(emp);
    }
    public OrganizationUnit getUnit(String deptName)
    {
        if (departmentName.equals(deptName))
            return this;
        return null;
    }
    
	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((departmentName == null) ? 0 : departmentName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrganizationUnit other = (OrganizationUnit) obj;
		if (departmentName == null) {
			if (other.departmentName != null)
				return false;
		} else if (!departmentName.equals(other.departmentName))
			return false;
		return true;
	}
}
