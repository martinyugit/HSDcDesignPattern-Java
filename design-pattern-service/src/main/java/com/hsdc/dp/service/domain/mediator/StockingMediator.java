package com.hsdc.dp.service.domain.mediator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.hsdc.dp.intf.dto.mediator.Product;
import com.hsdc.dp.intf.dto.mediator.Stocking;

public class StockingMediator extends Mediator implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7688211834050355975L;
	private static volatile StockingMediator instance;
    private static Object syncRoot = new Object();
    public static StockingMediator getInstance(){
        if (instance == null)
        {
            synchronized (syncRoot)
            {
                if (instance == null)
                    instance = new StockingMediator();
            }
        }
        return instance;
    }
    private List<OrderColleague> orderColleagues;
    private List<StockInColleague> stockInColleagues;
    
    private StockingMediator() {
        orderColleagues = new ArrayList<OrderColleague>();
        stockInColleagues = new ArrayList<StockInColleague>();
    }

	@Override
	public <T> void negociate(Colleague<T> sender, Product product) {
		for (Stocking s : Db.getInstance().getStocking()) {
			if (s.getProduct().getProductName().equals(product.getProductName())) {
				if ((sender instanceof OrderColleague) && s.getQuantity() < 1) {
					for(StockInColleague sc : stockInColleagues)
						sc.notify(product.getProductName());
				}
				if ((sender instanceof StockInColleague) && s.getQuantity() > 0) {
					for (OrderColleague oc : orderColleagues)
						oc.notify(product.getProductName());
				}
				break;
			}
		}
	}

	public List<OrderColleague> getOrderColleagues() {
		return orderColleagues;
	}

	public void setOrderColleagues(List<OrderColleague> orderColleagues) {
		this.orderColleagues = orderColleagues;
	}

	public List<StockInColleague> getStockInColleagues() {
		return stockInColleagues;
	}

	public void setStockInColleagues(List<StockInColleague> stockInColleagues) {
		this.stockInColleagues = stockInColleagues;
	}

}
