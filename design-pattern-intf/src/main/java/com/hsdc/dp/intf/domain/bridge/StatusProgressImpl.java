package com.hsdc.dp.intf.domain.bridge;

import com.hsdc.dp.intf.dto.bridge.OrderProgress;

public interface StatusProgressImpl {
	OrderProgress getCurrentOrderProgress(String oid);
}
