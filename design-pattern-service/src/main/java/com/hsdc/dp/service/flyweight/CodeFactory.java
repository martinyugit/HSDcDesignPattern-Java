package com.hsdc.dp.service.flyweight;

import java.util.concurrent.ConcurrentHashMap;

import com.hsdc.dp.intf.domain.flyweight.Code;

public class CodeFactory {
	private static final Object lock = new Object();
	private static volatile CodeFactory instance;
	private ConcurrentHashMap<String, Code> flyweights = new ConcurrentHashMap<String, Code>();
	
	private CodeFactory() { }
	
	public static CodeFactory getInstance()
    {
        if (instance == null)
        {
        	synchronized (lock)
            {
                if (instance == null)
                	instance = new CodeFactory();
            }
        }

        return instance;
    }
	
	public Code getCode(String type) 
    {
        if (type.equals("AREA"))
        	return new UncachedCode(type);
        if (!flyweights.contains(type))
        	flyweights.put(type, new CachedCode(type));
        return flyweights.get(type);
    }
}
