package com.hsdc.dp.intf.domain.flyweight;

import java.util.List;

import com.hsdc.dp.intf.dto.flyweight.CodeDto;

public interface Code {
	List<CodeDto> getCodeList(String parentValue);
}
