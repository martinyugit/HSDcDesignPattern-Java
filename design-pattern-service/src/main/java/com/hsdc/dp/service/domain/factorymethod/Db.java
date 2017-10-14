package com.hsdc.dp.service.domain.factorymethod;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.hsdc.dp.intf.service.factorymethod.Customer;
import com.hsdc.dp.intf.service.factorymethod.Product;
import com.hsdc.dp.intf.service.factorymethod.Supplier;

class Db {
	private static volatile Db instance;
	private static final Object lock = new Object();
    private List<Customer> customers;
    private List<Supplier> suppliers;
    private List<Product> products;
    
    private Db()
    {
        customers = new ArrayList<Customer>();
        customers.add(new Customer("CUST001", "保險公司" , "保險人" ));
        customers.add(new Customer("CUST002", "工研院",  "工研人" ));
        customers.add(new Customer( "CUST003", "鋼鐵公司", "鋼鐵人" ));
        suppliers = new ArrayList<Supplier>();
        suppliers.add(new Supplier( "SUPP001" , "Sparx Systems" , "xxxx@sparxsystems.com" ));
        suppliers.add(new Supplier("SUPP002", "Microsfot", "yyyy@microsoft.com" ));
        products = new ArrayList<Product>();
        products.add(new Product("PROD001" , "Enterprise Architect Corporate Edition" , "Software" , new BigDecimal(10000) , false ));
        products.add(new Product("PROD002", "Visual Studtio 2013 Ultimate Edition", "Software", new BigDecimal(200000 ), false ));
        products.add(new Product("PROD003", "HSDc Sequece Plugin", "Software", new BigDecimal(3500) , false ));
        products.add(new Product("PROD004", "HSDc Workflow Engine", "Open Source", BigDecimal.ZERO , false));
        products.add(new Product("PROD005", "Borland Together", "Software", new BigDecimal(180000), true));
    }
    
    List<Customer> getCustomers() {
        return this.customers;
    }
    
    List<Supplier> getSuppliers() {
        return this.suppliers;
    }
    
    List<Product> getProducts() {
	            return this.products;
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
}
