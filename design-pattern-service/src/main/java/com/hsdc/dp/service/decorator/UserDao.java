package com.hsdc.dp.service.decorator;

class UserDao {
	String getPassword(String userId)
    {
        if (userId.equals("ringle"))
        {
            return "12345";
        }
        if (userId.equals("kenming"))
        {
            return "54321";
        }
        return null;
    }
}
