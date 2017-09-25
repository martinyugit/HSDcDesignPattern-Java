package com.hsdc.dp.service.singleton;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class IDGeneratorSingleton {
	private static final Object lock = new Object();
	private static volatile IDGeneratorSingleton instance;
	
	private Map<Form, Integer> idCounter;
	
	private IDGeneratorSingleton() {
		//HashMap is not thread safe
		//thread safe use : https://yemengying.com/2016/05/07/threadsafe-hashmap/
			//		Hashtable
			//	v	ConcurrentHashMap
			//		Synchronized Map
		 this.idCounter = new HashMap<Form, Integer>();
	}
	
	public String getNextID(String formType, Date formDate)
    {
        int currentId = 0;
        Form key = new Form(); //{ FormType = formType, FormDateStr = formDate.ToString("yyyyMMdd") };
        key.setFormType(formType);
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
        key.setFormDateStr(fmt.format(formDate));
        /*if (!IdCounter.TryGetValue(key, out currentId))
        {
            IdCounter.Add(key, currentId);
        }*/
        if (!idCounter.containsKey(key))
        	idCounter.put(key, currentId);
        currentId = idCounter.get(key);
        currentId += 1;
        
		idCounter.put(key, currentId);
        return key.getFormDateStr() + String.format("%04d",currentId);
    }

	public static IDGeneratorSingleton getInstance() {
		IDGeneratorSingleton r = instance;
	    if (r == null) {
	        synchronized (lock) {    // While we were waiting for the lock, another 
	            r = instance;        // thread may have instantiated the object.
	            if (r == null) {  
	                r = new IDGeneratorSingleton();
	                instance = r;
	            }
	        }
	    }
	    return r;
	}
}
