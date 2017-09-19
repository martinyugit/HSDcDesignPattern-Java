package com.hsdc.dp.service.builder;

import com.hsdc.dp.intf.domain.builder.OfficeFormBuilder;
import com.hsdc.dp.intf.service.builder.EOfficeDirector;

public class EOfficeDirectorImpl<T> implements EOfficeDirector<T> {

	public T construct(OfficeFormBuilder<T> builder) {
		builder.buildMaster();
        builder.buildDetails();
        return builder.getResult();
	}

}
