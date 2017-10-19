package com.hsdc.dp.service.cor;

import org.springframework.stereotype.Service;

import com.hsdc.dp.intf.service.cor.HandlerUco;

@Service
public class HandlerUcoImpl implements HandlerUco {

	public String execute(int handlerNum) {

        System.out.println("----------------------------------------------");

        Handler rootChain = new Handler("ID-0");
		for(int i=1; i<handlerNum; i++ ) {
	        rootChain.add(new Handler("ID-" + String.valueOf(i)));
		}
        rootChain.wrapAround(rootChain);

        for (int i = 1; i <= handlerNum; i++) {
            System.out.println("Operation #" + i + ":");
            rootChain.execute(i);
            System.out.println();
        }
		
        return null;
	}

}
