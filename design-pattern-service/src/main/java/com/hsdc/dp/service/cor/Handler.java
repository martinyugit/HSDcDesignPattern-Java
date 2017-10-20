package com.hsdc.dp.service.cor;

import java.util.Random;

public class Handler {
	private final static Random RANDOM = new Random();
	private Handler nextHandler;
	
	private int handlerDollar;
	public Handler(int handlerDollar) {
		this.handlerDollar = handlerDollar;
	}

	boolean hasNextHandler() {
		return nextHandler != null;
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

	String execute(int num) {
		StringBuffer out = new StringBuffer();
		
		int unit = num / handlerDollar;
		num = num % handlerDollar;

		System.out.println(handlerDollar);
		System.out.println(unit);
		System.out.println(num);
		
		out.append("\n");
		out.append("[" + handlerDollar + "]: " + unit + "(units)");
		
		if(hasNextHandler()) {
			out.append(nextHandler.execute(num));
		}
		
		return out.toString();
	}

	static public void main(String[] args) {
        Handler rootChain = new Handler(1000);
        rootChain.add(new Handler(500));
        rootChain.add(new Handler(100));
        rootChain.add(new Handler(50));
        rootChain.add(new Handler(10));
        rootChain.add(new Handler(5));
        rootChain.add(new Handler(1));

        System.out.println(rootChain.execute(1287).replaceAll("<br>", "\n"));
	}

	
	
}


