package com.hsdc.dp.intf.service.decorator;

import java.util.List;

import com.hsdc.dp.intf.dto.decorator.Function;
import com.hsdc.dp.intf.dto.decorator.User;

public interface UserService {
	User login(String userId, String password);
    List<Function> getAclList(String userId);
}
