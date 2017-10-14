package com.hsdc.dp.service.domain.factorymethod;

import java.util.List;

public abstract class MaintainJobDao<T> {
	public abstract void create(T obj);
    public abstract List<T> read();
    public abstract void update(T obj);
    public abstract void delete(T obj);
}
