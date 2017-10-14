package idv.kiwi.app.decorator;

import idv.kiwi.app.vo.UserVO;

public class PolicyRootImpl implements IPolicyRoot {

	/** */
	private static final long serialVersionUID = -6844389702541512907L;

	public void passSecurityCheck(UserVO userVO) {
		String memo = userVO.getMemo();
		
		if(userVO.getUserStatus().equals("A")) {
			memo = memo + "帳號有效\n";
		} else {
			memo = memo + "帳號無效\n";
		}
		
		userVO.setMemo(memo);
	}

}
