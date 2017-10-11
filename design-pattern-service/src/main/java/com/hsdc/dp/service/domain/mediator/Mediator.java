package com.hsdc.dp.service.domain.mediator;

import java.io.Serializable;

import com.hsdc.dp.intf.dto.mediator.Product;

public abstract class Mediator implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4399770745305773540L;
	
	public abstract <T> void negociate(Colleague<T> sender, Product product);

}
