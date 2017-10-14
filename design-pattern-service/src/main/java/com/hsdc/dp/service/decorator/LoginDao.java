package com.hsdc.dp.service.decorator;

import java.util.HashMap;
import java.util.Map;

import com.hsdc.dp.intf.dto.decorator.User;

class LoginDao {
	User getMemberData(String userId)
    {
        return getUsers().get(userId);
    }
	
	private Map<String, User> getUsers()
    {
		Map<String, User> users = new HashMap<String, User>();
        users.put("ringle", new User("ringle", "Ringle Lai"));
        users.put("kenming", new User("kenming", "Kenming Wang" ));
        return users;
    }
}
