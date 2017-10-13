package idv.kiwi.app.service;

import java.io.Serializable;
import java.util.Map;

import idv.kiwi.app.codetable.UserDataCodeTable;
import idv.kiwi.app.decorator.FirstLogonPolicyRoot;
import idv.kiwi.app.decorator.IPolicyRoot;
import idv.kiwi.app.decorator.PolicyRootImpl;
import idv.kiwi.app.decorator.PwdModifyPolicyRoot;
import idv.kiwi.app.vo.UserVO;

public class LogonService implements Serializable {
	/** */
	private static final long serialVersionUID = -6230984329093458580L;
	
	public UserVO logon(String id, String pwd) {
		Map<String, UserVO> userMap = UserDataCodeTable.getUserData();
		UserVO tmpUserVO = userMap.get(id);
		
		if(tmpUserVO != null) {
			if(tmpUserVO.getUserPwd().equals(pwd)) {
				tmpUserVO.setMemo("帳密正確\n");
			} else {
				tmpUserVO = null;
			}
		}
		
		if(tmpUserVO != null) {
			passSecurityCheck(tmpUserVO);
		}
		
		return tmpUserVO;
	}
	
	private void passSecurityCheck(UserVO userVO) {
		IPolicyRoot iPolicyRoot = new PolicyRootImpl();
		
		if("H".equals(userVO.getUserType())) { // 內勤
			iPolicyRoot.passSecurityCheck(userVO);
		} else if("A".equals(userVO.getUserType())) { // 保戶
			FirstLogonPolicyRoot flPolicyRoot = new FirstLogonPolicyRoot(iPolicyRoot);
			flPolicyRoot.passSecurityCheck(userVO);
		} else if("D".equals(userVO.getUserType())) { // 保經代
			PwdModifyPolicyRoot flpwPolicyRoot = new PwdModifyPolicyRoot(new FirstLogonPolicyRoot(iPolicyRoot));
			flpwPolicyRoot.passSecurityCheck(userVO);
		}
	}
}
