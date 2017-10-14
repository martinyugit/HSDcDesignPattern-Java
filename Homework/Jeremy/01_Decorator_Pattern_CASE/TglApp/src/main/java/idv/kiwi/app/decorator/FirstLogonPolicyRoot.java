package idv.kiwi.app.decorator;

import idv.kiwi.app.vo.UserVO;

public class FirstLogonPolicyRoot extends PolicyRootDecorator {
	/** */
	private static final long serialVersionUID = 8182454355449020133L;

	public FirstLogonPolicyRoot(IPolicyRoot policyRoot) {
		super(policyRoot);
	}

	@Override
	public void passSecurityCheck(UserVO userVO) {
		java.util.Date lastLogonDate = userVO.getLastLogonDate();
		
		if(lastLogonDate == null) {
			String memo = userVO.getMemo();
			memo = memo + "第一次登入\n";
			userVO.setMemo(memo);
		}
	}

}
