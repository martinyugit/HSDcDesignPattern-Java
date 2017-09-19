package com.hsdc.dp.service.builder;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.hsdc.dp.intf.domain.builder.OfficeFormBuilder;
import com.hsdc.dp.intf.dto.builder.ApplyExpense;
import com.hsdc.dp.intf.dto.builder.ApplyExpenseDetail;

@Service
public class ApplyExpenseBuilder implements OfficeFormBuilder<ApplyExpense> {
	private ApplyExpense dto;

	public void buildMaster() {
		dto = new ApplyExpense();
	}

	public void buildDetails() {
		dto.setLineItems(new ArrayList<ApplyExpenseDetail>());
	}

	public ApplyExpense getResult() {
		return dto;
	}

}
