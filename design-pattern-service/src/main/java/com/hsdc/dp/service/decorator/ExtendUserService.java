package com.hsdc.dp.service.decorator;

import java.util.List;

import com.hsdc.dp.intf.dto.decorator.Function;
import com.hsdc.dp.intf.dto.decorator.User;
import com.hsdc.dp.intf.service.decorator.UserService;

public abstract class ExtendUserService implements UserService {
	
	protected UserService component;
    public ExtendUserService(UserService component)
    {
        this.component = component;
    }

	public abstract User login(String userId, String password);

	public abstract List<Function> getAclList(String userId);

}
