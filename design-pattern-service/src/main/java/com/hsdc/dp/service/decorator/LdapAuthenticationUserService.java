package com.hsdc.dp.service.decorator;

import com.hsdc.dp.intf.dto.decorator.User;
import com.hsdc.dp.intf.service.decorator.UserService;

public class LdapAuthenticationUserService extends AuthenticationUserService {

	public LdapAuthenticationUserService(UserService component) {
		super(component);
	}

	@Override
	public User login(String userId, String password) {
		User baseUser = component.login(userId, password);
        LdapAdapter adapter = new LdapAdapter();
        if (adapter.isLdapUser(userId, password))
        {
            baseUser.setUserName(baseUser.getUserName() + " FROM LDAP");
            return baseUser;
        }
        return null;
	}

}
