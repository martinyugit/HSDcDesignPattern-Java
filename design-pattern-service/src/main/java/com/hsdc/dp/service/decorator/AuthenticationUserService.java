package com.hsdc.dp.service.decorator;

import java.util.List;

import com.hsdc.dp.intf.dto.decorator.Function;
import com.hsdc.dp.intf.service.decorator.UserService;

public abstract class AuthenticationUserService extends ExtendUserService {

	public AuthenticationUserService(UserService component) {
		super(component);
	}

	@Override
	public List<Function> getAclList(String userId) {
		return component.getAclList(userId);
	}

}
