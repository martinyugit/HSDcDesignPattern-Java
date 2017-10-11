package com.hsdc.dp.service.decorator;

import java.util.ArrayList;
import java.util.List;

import com.hsdc.dp.intf.dto.decorator.Function;
import com.hsdc.dp.intf.dto.decorator.User;
import com.hsdc.dp.intf.service.decorator.UserService;

public class DefaultUserService implements UserService {

	public User login(String userId, String password) {
		LoginDao dao = new LoginDao();
        User u = dao.getMemberData(userId);
        return u;
	}

	public List<Function> getAclList(String userId) {
		List<Function> defaultAcl = new ArrayList<Function>();
        defaultAcl.add(new Function("BuilderPattern", "/bd"));
        defaultAcl.add(new Function("PrototypePattern","/pt" ));
        return defaultAcl;
	}

}
