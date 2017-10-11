package com.hsdc.dp.service.decorator;

class LdapAdapter {
	boolean isLdapUser(String userId, String password)
    {
        return (((userId.equals("ringle")) && (password.equals("54321"))) ||
            ((userId.equals("kenming")) && (password.equals("12345"))));
    }
}
