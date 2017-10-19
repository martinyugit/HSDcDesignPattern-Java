package com.hsdc.dp.service.cor;

import java.util.Random;

public class Handler {
	private final static Random RANDOM = new Random();
	private String id;
	private Handler nextHandler;
	
	public Handler(String handlerId) {
		id = handlerId;
	}

	void add(Handler handler) {
		if(nextHandler == null) {
			nextHandler = handler;
		}
		else {
			nextHandler.add(handler);
		}
	}

	void wrapAround(Handler wrapHandler) {
		if(nextHandler == null) {
			nextHandler = wrapHandler;
		}
		else {
			nextHandler.add(wrapHandler);
		}
	}

	void execute(int num) {
		if(RANDOM.nextInt(4) != 0) {
			System.out.println("     [" + id + "]-busy");
			nextHandler.execute(num);
		}
		else {
			System.out.println("     [" + id + "]-handled-" + num);
		}
		
	}

	static public void main(String[] args) {
        Handler rootChain = new Handler("1");
        rootChain.add(new Handler("2"));
        rootChain.add(new Handler("3"));
        rootChain.add(new Handler("4"));
        rootChain.add(new Handler("5"));
        rootChain.wrapAround(rootChain);
        for (int i = 1; i < 10; i++) {
            System.out.println("Operation #" + i + ":");
            rootChain.execute(i);
            System.out.println();
        }
	}

	
	
}


