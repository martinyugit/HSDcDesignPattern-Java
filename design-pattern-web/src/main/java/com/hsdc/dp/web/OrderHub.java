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
import com.hsdc.dp.intf.dto.mediator.Order;
import com.hsdc.dp.intf.dto.mediator.Product;
import com.hsdc.dp.intf.service.mediator.StockingUco;
import com.hsdc.dp.service.domain.mediator.OrderColleague;
import com.hsdc.dp.service.domain.mediator.StockingMediator;

@Controller
public class OrderHub implements NotifierProxy, ApplicationListener<SessionConnectEvent> {

	
	@Autowired private StockingUco uco;
	@Autowired private SimpMessagingTemplate template;
	@RequestMapping(value="/md/order/{prodName}", method=RequestMethod.GET)
	public @ResponseBody Boolean send(@PathVariable String prodName) {
		StockingMediator.getInstance().getOrderColleagues().get(0).send(new Order(new Product(prodName)));
		if (uco.checkQunatity(prodName)) {
			template.convertAndSend("/topic/addSellOut", prodName);
		}
		return true;
	}
	
	@MessageMapping("/hasStocking")
	public String hasStocking(String prodName) {
		return prodName;
	}
	public void notify(String prodName) {
		template.convertAndSend("/topic/hasStocking", prodName);
	}
	
	@MessageMapping("/addSellOut")
	public String sellOut(String prodName) {
		return prodName;
	}

	public void onApplicationEvent(SessionConnectEvent event) {
		System.out.print("Connect Order!");
		StompHeaderAccessor sha = StompHeaderAccessor.wrap(event.getMessage());
		String val = sha.getNativeHeader("method").get(0);
		if (!val.equals("order"))
			return;
		StockingMediator.getInstance().getOrderColleagues().add(new OrderColleague(StockingMediator.getInstance(), this));
	}

}
