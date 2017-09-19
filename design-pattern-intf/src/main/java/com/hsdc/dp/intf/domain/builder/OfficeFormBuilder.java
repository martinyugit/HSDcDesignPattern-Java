package com.hsdc.dp.intf.domain.builder;

public interface OfficeFormBuilder<T> {
	public void buildMaster();
    public void buildDetails();
    public T getResult();
}
