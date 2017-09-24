package com.hsdc.dp.service.decorator;

import com.hsdc.dp.intf.dto.decorator.User;
import com.hsdc.dp.intf.service.decorator.UserService;

public class DbAuthenticationUserService extends AuthenticationUserService {

	public DbAuthenticationUserService(UserService component) {
		super(component);
	}

	@Override
	public User login(String userId, String password) {
		 User baseUser = component.login(userId, password);
         if (baseUser == null)
             return baseUser;
         baseUser.setUserName(baseUser.getUserName() + " FROM DB");
         String dbpw = (new UserDao()).getPassword(userId);
         if ((dbpw != null) && (dbpw.equals(password)))
             return baseUser;
         return null;
	}

}
