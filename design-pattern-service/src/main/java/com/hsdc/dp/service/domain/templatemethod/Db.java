package com.hsdc.dp.service.domain.templatemethod;

import java.util.ArrayList;
import java.util.List;

import com.hsdc.dp.intf.dto.templatemethod.Policy;
import com.hsdc.dp.intf.dto.templatemethod.Policy.PolicyType;

class Db {
	private static volatile Db instance;
	private static final Object lock = new Object();
    private List<Policy> db;

    private Db()
    {
        db = new ArrayList<Policy>();
        db.add(new PolicyImpl("01010001", "健康險1", "Ringle", "Ringle", PolicyType.NORMAL));
        db.add(new PolicyImpl("01010002", "健康險2", "Ringle", "Ringle", PolicyType.HAS_CLAIMED));
        db.add(new PolicyImpl("01010003",  "壽險1", "Ringle", "Test", PolicyType.IN_APPROVE));
        db.add(new PolicyImpl("01010004", "壽險2", "Ringle", "Ajewl", PolicyType.NORMAL));
        db.add(new PolicyImpl("01010005", "壽險3", "Ringle", "Ringle", PolicyType.IN_APPROVE));
    }
    
    static Db getInstance()
    {
    	Db r = instance;
	    if (r == null) {
	        synchronized (lock) {    // While we were waiting for the lock, another 
	            r = instance;        // thread may have instantiated the object.
	            if (r == null) {  
	                r = new Db();
	                instance = r;
	            }
	        }
	    }
	    return r;
    }
    
    List<Policy> getPolicies()
    {
        return this.db;
    }
}
