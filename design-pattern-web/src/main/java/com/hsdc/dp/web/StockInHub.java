package com.hsdc.dp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.messaging.SessionConnectEvent;

import com.hsdc.dp.intf.domain.mediator.NotifierProxy;
import com.hsdc.dp.intf.dto.mediator.Product;
import com.hsdc.dp.intf.dto.mediator.StockIn;
import com.hsdc.dp.service.domain.mediator.StockInColleague;
import com.hsdc.dp.service.domain.mediator.StockingMediator;

@Controller
public class StockInHub implements NotifierProxy, ApplicationListener<SessionConnectEvent> {
	
	@MessageMapping("/sellOut")
	public String sellOut(String prodName) {
		return prodName;
	}
	
	@Autowired private SimpMessagingTemplate template;
	public void notify(String prodName) {
		template.convertAndSend("/topic/sellOut", prodName);
	}
	
	@RequestMapping(value="/md/stockIn/{prodName}/{qty}", method=RequestMethod.GET)
	public @ResponseBody Boolean send(@PathVariable String prodName, @PathVariable int qty) {
		StockingMediator.getInstance().getStockInColleagues().get(0).send(new StockIn(qty, new Product(prodName)));
		return true;
	}

	public void onApplicationEvent(SessionConnectEvent event) {
		System.out.print("Connect StockIn!");
		StompHeaderAccessor sha = StompHeaderAccessor.wrap(event.getMessage());
		String val = sha.getNativeHeader("method").get(0);
		if (!val.equals("stockin"))
			return;
		StockingMediator.getInstance().getStockInColleagues().add(new StockInColleague(StockingMediator.getInstance(), this));
	}

}
