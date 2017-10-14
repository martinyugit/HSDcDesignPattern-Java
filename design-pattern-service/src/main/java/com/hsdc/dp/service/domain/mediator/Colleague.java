package com.hsdc.dp.service.domain.mediator;

import com.hsdc.dp.intf.domain.mediator.NotifierProxy;

public abstract class Colleague<T> implements NotifierProxy {
	protected Mediator mediator;
    protected NotifierProxy proxy;
    public Colleague(Mediator mediator, NotifierProxy proxy)
    {
        this.proxy = proxy;
        this.mediator = mediator;
    }
    public abstract void send(T obj);
}
