package com.hsdc.dp.service.builder;

import org.springframework.stereotype.Service;

import com.hsdc.dp.intf.dto.builder.ApplyExpense;
import com.hsdc.dp.intf.service.builder.SaveEOfficeUco;

@Service
public class SaveApplyExpenseUcoImpl implements SaveEOfficeUco<ApplyExpense> {

	public ApplyExpense save(ApplyExpense form) {
		if (form != null)
			form.setApplyExpenseID("AE010001");
        return form;
	}

}
