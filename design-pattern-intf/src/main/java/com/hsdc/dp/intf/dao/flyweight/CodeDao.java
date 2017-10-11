package com.hsdc.dp.intf.dao.flyweight;

import java.util.List;

import com.hsdc.dp.intf.dto.flyweight.CodeDto;

public interface CodeDao {
	List<CodeDto> query(String type);
	List<CodeDto> query(String type, String parentValue);
}
