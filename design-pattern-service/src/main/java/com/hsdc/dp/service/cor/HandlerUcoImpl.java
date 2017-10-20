package com.hsdc.dp.service.cor;

import org.springframework.stereotype.Service;

import com.hsdc.dp.intf.service.cor.HandlerUco;

@Service
public class HandlerUcoImpl implements HandlerUco {

	public String execute(int handlerNum) {

        Handler rootChain = new Handler(1000);
        rootChain.add(new Handler(500));
        rootChain.add(new Handler(100));
        rootChain.add(new Handler(50));
        rootChain.add(new Handler(10));
        rootChain.add(new Handler(5));
        rootChain.add(new Handler(1));
//        rootChain.wrapAround(rootChain);

        return rootChain.execute(handlerNum);
	}

}
