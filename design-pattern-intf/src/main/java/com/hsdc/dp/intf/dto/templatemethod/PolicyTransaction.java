package com.hsdc.dp.intf.dto.templatemethod;

import java.io.Serializable;
import java.util.List;

public interface PolicyTransaction extends Serializable {
	public boolean getCanEdit();
    public List<Policy> getPolicies();
}
