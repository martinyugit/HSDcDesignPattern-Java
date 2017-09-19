package com.hsdc.dp.service.builder;

import com.hsdc.dp.intf.domain.builder.OfficeFormBuilder;
import com.hsdc.dp.intf.dto.builder.Leave;

public class LeaveBuilder implements OfficeFormBuilder<Leave> {
	private Leave dto = null;

	public void buildMaster() {
		dto = new Leave();
	}

	public void buildDetails() {
		
	}

	public Leave getResult() {
		return dto;
	}

}
