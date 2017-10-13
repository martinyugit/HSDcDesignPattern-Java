package idv.kiwi.app.codetable;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import idv.kiwi.app.vo.UserVO;

public class UserDataCodeTable {
	private static Map<String, UserVO> userMap;

	static {
		userMap = new HashMap<String, UserVO>();

		Calendar cal = Calendar.getInstance();

		UserVO[] userVOs = new UserVO[5];

		userVOs[0] = new UserVO();
		userVOs[0].setUserId("001137");
		userVOs[0].setUserName("KiWi");
		userVOs[0].setUserPwd("uatuat");
		userVOs[0].setUserStatus("A");
		userVOs[0].setUserType("H");
		userVOs[0].setDuringChgPwdPeriod(90);
		cal.set(Calendar.YEAR, 2017);
		cal.set(Calendar.MONTH, 6); // mean 7
		cal.set(Calendar.DATE, 15);

		userVOs[0].setLastLogonDate(cal.getTime());
		userVOs[0].setPwdChgDate(cal.getTime());

		userMap.put(userVOs[0].getUserId(), userVOs[0]);

		userVOs[1] = new UserVO();
		userVOs[1].setUserId("001177");
		userVOs[1].setUserName("Bob");
		userVOs[1].setUserPwd("uatuat");
		userVOs[1].setUserStatus("I");
		userVOs[1].setUserType("H");
		userVOs[1].setDuringChgPwdPeriod(90);
		cal.set(Calendar.YEAR, 2017);
		cal.set(Calendar.MONTH, 6); // mean 7
		cal.set(Calendar.DATE, 15);

		userVOs[1].setLastLogonDate(cal.getTime());
		userVOs[1].setPwdChgDate(cal.getTime());

		userMap.put(userVOs[1].getUserId(), userVOs[1]);

		userVOs[2] = new UserVO();
		userVOs[2].setUserId("H123456789");
		userVOs[2].setUserName("Mary");
		userVOs[2].setUserPwd("uatuat");
		userVOs[2].setUserStatus("A");
		userVOs[2].setUserType("A");
		userVOs[2].setDuringChgPwdPeriod(90);
		cal.set(Calendar.YEAR, 2017);
		cal.set(Calendar.MONTH, 6); // mean 7
		cal.set(Calendar.DATE, 15);

		userVOs[2].setLastLogonDate(null);
		userVOs[2].setPwdChgDate(cal.getTime());

		userMap.put(userVOs[2].getUserId(), userVOs[2]);
		
		userVOs[3] = new UserVO();
		userVOs[3].setUserId("H1236464646");
		userVOs[3].setUserName("TGL");
		userVOs[3].setUserPwd("uatuat");
		userVOs[3].setUserStatus("A");
		userVOs[3].setUserType("A"); // 保經代
		userVOs[3].setDuringChgPwdPeriod(90);
		cal.set(Calendar.YEAR, 2017);
		cal.set(Calendar.MONTH, 6); // mean 7
		cal.set(Calendar.DATE, 15);

		userVOs[3].setLastLogonDate(cal.getTime());
		userVOs[3].setPwdChgDate(cal.getTime());

		userMap.put(userVOs[3].getUserId(), userVOs[3]);
		
		userVOs[4] = new UserVO();
		userVOs[4].setUserId("D00002");
		userVOs[4].setUserName("QQ");
		userVOs[4].setUserPwd("uatuat");
		userVOs[4].setUserStatus("A");
		userVOs[4].setUserType("D"); // 保經代
		userVOs[4].setDuringChgPwdPeriod(90);
		cal.set(Calendar.YEAR, 2017);
		cal.set(Calendar.MONTH, 6); // mean 7
		cal.set(Calendar.DATE, 15);

		userVOs[4].setLastLogonDate(cal.getTime());
		userVOs[4].setPwdChgDate(cal.getTime());

		userMap.put(userVOs[4].getUserId(), userVOs[4]);
	}
	
	public static Map<String, UserVO> getUserData() {
		return userMap;
	}
}
