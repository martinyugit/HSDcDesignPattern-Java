package com.hsdc.dp.service.builder;

import org.springframework.stereotype.Service;

import com.hsdc.dp.intf.dto.builder.Leave;
import com.hsdc.dp.intf.service.builder.SaveEOfficeUco;

@Service
public class SaveLeaveUcoImpl implements SaveEOfficeUco<Leave> {

	public Leave save(Leave form) {
		if (form != null)
			form.setLeaveID("LE010001");
        return form;
	}

}
