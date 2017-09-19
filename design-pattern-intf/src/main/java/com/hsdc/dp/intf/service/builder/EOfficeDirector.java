package com.hsdc.dp.intf.service.builder;

import com.hsdc.dp.intf.domain.builder.OfficeFormBuilder;

public interface EOfficeDirector<T> {
	public T construct(OfficeFormBuilder<T> builder);
}
