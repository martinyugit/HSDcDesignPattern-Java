package com.hsdc.dp.service.composite;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hsdc.dp.intf.dto.composite.Employee;
import com.hsdc.dp.intf.service.composite.ManageRingelOrgUco;

@Service
public class ManageRingelOrgUcoImpl implements ManageRingelOrgUco {

	public List<String> getAllDepartmentName() {
		OrganizationUnit root = getAllDepartments();
        List<String> depts = new ArrayList<String>();
        depts.add(root.getDepartmentName());
        for (OrganizationUnit u : root.getChildren()) {
            depts.add(u.getDepartmentName());
        }
        return depts;
	}

	public List<String> getAllEmployeeName(String deptName) {
		OrganizationUnit ou = getDepartment(deptName);
        List<String> emps = new ArrayList<String>();
        for (Employee e : ou.getAllEmployee()) 
        {
            emps.add(e.getName());
        }
        return emps;
	}
	
	private OrganizationUnit getDepartment(String deptName)
    {
        OrganizationUnit root = getAllDepartments();
        return root.getUnit(deptName);
    }

    private OrganizationUnit getAllDepartments()
    {
        OrganizationUnit leaf, comp, root;
        leaf = new OrganizationUnitLeaf();
        leaf.setDepartmentName("資訊課");
        Employee e1 = new Employee("王小明");
        leaf.addEmployee(e1);
        e1 = new Employee("賴阿仁");
        leaf.addEmployee(e1);
        comp = new OrganizationUnitComposite();
        comp.setDepartmentName("行政部");
        e1 = new Employee("趙六");
        comp.addEmployee(e1);
        e1 = new Employee( "錢七");
        comp.addEmployee(e1);
        e1 = new Employee("孫八");
        comp.addEmployee(e1);
        comp.add(leaf);
        leaf = new OrganizationUnitLeaf();
        leaf.setDepartmentName("人資課");
        e1 = new Employee("趙守志");
        leaf.addEmployee(e1);
        e1 = new Employee("吳人來");
        leaf.addEmployee(e1);
        comp.add(leaf);
        root = new OrganizationUnitComposite();
        root.setDepartmentName("總經理室");
        e1 = new Employee("王一");
        root.addEmployee(e1);
        e1 = new Employee( "王二");
        root.addEmployee(e1);
        root.add(comp);
        leaf = new OrganizationUnitLeaf();
        leaf.setDepartmentName("出納課");
        e1 = new Employee("錢出去");
        leaf.addEmployee(e1);
        comp = new OrganizationUnitComposite();
        comp.setDepartmentName("財務部");
        e1 = new Employee("李四");
        comp.addEmployee(e1);
        comp.add(leaf);
        leaf = new OrganizationUnitLeaf();
        leaf.setDepartmentName("會計課");
        e1 = new Employee("錢多多");
        leaf.addEmployee(e1);
        e1 = new Employee("錢守住");
        leaf.addEmployee(e1);
        comp.add(leaf);
        root.add(comp);
        comp = new OrganizationUnitComposite();
        comp.setDepartmentName("營業部");
        e1 = new Employee("張三");
        comp.addEmployee(e1);
        e1 = new Employee("張五");
        comp.addEmployee(e1);
        leaf = new OrganizationUnitLeaf();
        leaf.setDepartmentName("營業二課");
        e1 = new Employee("鄭十一");
        leaf.addEmployee(e1);
        e1 = new Employee("歐陽十二");
        leaf.addEmployee(e1);
        e1 = new Employee("賴十三");
        leaf.addEmployee(e1);
        comp.add(leaf);
        leaf = new OrganizationUnitLeaf();
        leaf.setDepartmentName("營業一課");
        e1 = new Employee("周九");
        leaf.addEmployee(e1);
        e1 = new Employee("吳十");
        leaf.addEmployee(e1);
        comp.add(leaf);
        root.add(comp);
        return root;
    }

}
