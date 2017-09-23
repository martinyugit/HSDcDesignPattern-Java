package com.hsdc.dp.intf.service.composite;

import java.util.List;

public interface ManageRingelOrgUco {
	List<String> getAllDepartmentName();
	List<String> getAllEmployeeName(String deptName);
}
