package com.hsdc.dp.service.facade;

import org.springframework.stereotype.Service;

import com.hsdc.dp.intf.domain.interpreter.MoneyContext;
import com.hsdc.dp.intf.domain.interpreter.MoneyExpression;
import com.hsdc.dp.intf.service.facade.ServiceUco;
import com.hsdc.dp.intf.service.interpreter.MoneyUco;

@Service
public class ServiceUcoImpl implements ServiceUco {

	public String doAction(String str) {
		
		String result = "input : [" + str + "]";
		
		Some some = new Some();
		result += "<br>do... : [" + some.run(str) + "]";

		Other other = new Other();
		result += "<br>do... : [" + other.run(str) + "]";
		
		Another another = new Another();
		result += "<br>do... : [" + another.run(str) + "]";

		return result;
	}

}
