package com.hsdc.dp.service.domain.mediator;

import java.util.ArrayList;
import java.util.List;

import com.hsdc.dp.intf.dto.mediator.Product;
import com.hsdc.dp.intf.dto.mediator.Stocking;

class Db {
	private static volatile Db instance;
    private static Object syncRoot = new Object();
    private List<Stocking> db;
    
    private Db() {
        db = new ArrayList<Stocking>();
        db.add(new Stocking(0, new Product("Ringle's Book" )));
        db.add(new Stocking(100, new Product("Other's Book")));
        db.add(new Stocking(2, new Product("GoF")));
    }
    
    static Db getInstance() {
            if (instance == null)
            {
            	synchronized (syncRoot)
                {
                    if (instance == null)
                        instance = new Db();
                }
            }

            return instance;
    }
    
    List<Stocking> getStocking() {
        return this.db;
    }
}
