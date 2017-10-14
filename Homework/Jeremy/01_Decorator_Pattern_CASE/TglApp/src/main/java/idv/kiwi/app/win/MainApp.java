package idv.kiwi.app.win;

import java.util.LinkedHashSet;
import java.util.Set;

import idv.kiwi.app.service.LogonService;
import idv.kiwi.app.vo.UserVO;

public class MainApp {

	public static void main(String[] args) {
		LogonService logonService = new LogonService();
		
		Set<String> userIdSet = new LinkedHashSet<String>();
		
		userIdSet.add("001137");
		userIdSet.add("001177");
		userIdSet.add("H123456789");
		userIdSet.add("H1236464646");
		userIdSet.add("D00002");
		
		for(String userId: userIdSet) {
			UserVO userVO = logonService.logon(userId, "uatuat");
			
			System.out.println("userId: " + userId);
			
			if(userVO == null) {
				System.out.println("帳號或密碼錯誤\n");
			} else {
				System.out.println("userType" + userVO.getUserType());
				System.out.println(userVO.getMemo());
			}
			
			System.out.println("=======================\n");
		}
	}

}
