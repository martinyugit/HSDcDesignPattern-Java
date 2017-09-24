package com.hsdc.dp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hsdc.dp.intf.service.decorator.UserService;
import com.hsdc.dp.service.decorator.AuthorityUserService;
import com.hsdc.dp.service.decorator.DbAuthenticationUserService;
import com.hsdc.dp.service.decorator.DefaultUserService;
import com.hsdc.dp.service.decorator.LdapAuthenticationUserService;
import com.hsdc.dp.web.dto.ResultDto;

@Controller
public class DecoratorController {
	@RequestMapping(value = "/dec", method = RequestMethod.GET)
	public String index() {
		return "decindex";
	}
	
	@RequestMapping(value = "/dec/login/{type}", method = RequestMethod.GET)
	public @ResponseBody ResultDto login(@PathVariable String type, 
			 @RequestParam("userId") String userId, @RequestParam("password") String password) {
		UserService userService = new DefaultUserService();
		if (type.equals("db"))
			userService = new DbAuthenticationUserService(userService);
		if (type.equals("ldap"))
			userService = new AuthorityUserService(new LdapAuthenticationUserService(userService));
		return new ResultDto(userService.login(userId, password), userService.getAclList(userId));
	}
}
