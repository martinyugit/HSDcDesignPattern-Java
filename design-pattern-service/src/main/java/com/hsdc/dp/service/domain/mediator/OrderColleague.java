package com.hsdc.dp.service.domain.mediator;

import java.io.Serializable;

import com.hsdc.dp.intf.domain.mediator.NotifierProxy;
import com.hsdc.dp.intf.dto.mediator.Order;
import com.hsdc.dp.intf.dto.mediator.Stocking;

public class OrderColleague extends Colleague<Order> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1876552165350645880L;

	public OrderColleague(Mediator mediator, NotifierProxy proxy) {
		super(mediator, proxy);
	}

	public void notify(String prodName) {
		proxy.notify(prodName);
	}

	@Override
	public void send(Order obj) {
		for (Stocking s2 : Db.getInstance().getStocking())
			if (s2.getProduct().getProductName().equals(obj.getProduct().getProductName())) {
				if (s2.getQuantity() > 0)
					s2.setQuantity(s2.getQuantity()-1);
				break;
			}
		this.mediator.negociate(this, obj.getProduct());
	}
}
