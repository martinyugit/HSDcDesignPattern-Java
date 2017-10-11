package com.hsdc.dp.service.domain.mediator;

import java.io.Serializable;

import com.hsdc.dp.intf.domain.mediator.NotifierProxy;
import com.hsdc.dp.intf.dto.mediator.StockIn;
import com.hsdc.dp.intf.dto.mediator.Stocking;

public class StockInColleague extends Colleague<StockIn> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6918654973720966261L;

	public StockInColleague(Mediator mediator, NotifierProxy proxy) {
		super(mediator, proxy);
	}

	public void notify(String prodName) {
		this.proxy.notify(prodName);
	}

	@Override
	public void send(StockIn obj) {
		for (Stocking s2 : Db.getInstance().getStocking())
			if (s2.getProduct().getProductName().equals(obj.getProduct().getProductName())) {
				s2.setQuantity(s2.getQuantity() + obj.getQuantity());
			}
		this.mediator.negociate(this, obj.getProduct());
	}

}
