package com.hsdc.dp.service.decorator;

import java.util.List;

import com.hsdc.dp.intf.dto.decorator.Function;
import com.hsdc.dp.intf.dto.decorator.User;
import com.hsdc.dp.intf.service.decorator.UserService;

public class AuthorityUserService extends ExtendUserService {

	public AuthorityUserService(UserService component) {
		super(component);
	}

	@Override
	public User login(String userId, String password) {
		return component.login(userId, password);
	}

	@Override
	public List<Function> getAclList(String userId) {
		List<Function> baseAcl = component.getAclList(userId);
        Function addF = new Function("Singleton", "/sg");
        if (!baseAcl.contains(addF))
            baseAcl.add(addF);
        return baseAcl;
	}

}
