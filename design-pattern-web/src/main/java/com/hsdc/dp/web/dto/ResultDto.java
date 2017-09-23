package com.hsdc.dp.web.dto;

import java.io.Serializable;
import java.util.List;

import com.hsdc.dp.intf.dto.decorator.Function;
import com.hsdc.dp.intf.dto.decorator.User;

public class ResultDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7171383508718794187L;

	private User user;
    private List<Function> acl;
	public ResultDto(User user, List<Function> acl) {
		super();
		this.user = user;
		this.acl = acl;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Function> getAcl() {
		return acl;
	}
	public void setAcl(List<Function> acl) {
		this.acl = acl;
	}
    
    
}
