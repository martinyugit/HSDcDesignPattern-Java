package idv.kiwi.app.util;

import java.util.Calendar;

public class CommonUtil {
	public static int daysOfTwo(Calendar befor, Calendar after) {
        int day1 = befor.get(Calendar.DAY_OF_YEAR);
        int day2 = after.get(Calendar.DAY_OF_YEAR);
        
        return day2 - day1;
    }
}
