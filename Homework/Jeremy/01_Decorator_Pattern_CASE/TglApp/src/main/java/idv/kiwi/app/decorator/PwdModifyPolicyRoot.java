package idv.kiwi.app.decorator;

import java.util.Calendar;

import idv.kiwi.app.util.CommonUtil;
import idv.kiwi.app.vo.UserVO;

public class PwdModifyPolicyRoot extends PolicyRootDecorator {
	/** */
	private static final long serialVersionUID = 2754375299959370623L;

	public PwdModifyPolicyRoot(IPolicyRoot policyRoot) {
		super(policyRoot);
	}

	@Override
	public void passSecurityCheck(UserVO userVO) {
		String memo = userVO.getMemo();
		java.util.Date pwdChgDate = userVO.getPwdChgDate();
		int duringChgPwdPeriod = userVO.getDuringChgPwdPeriod();
		
		Calendar before = Calendar.getInstance();
		
		Calendar after = Calendar.getInstance();
		after.setTimeInMillis(pwdChgDate.getTime() + duringChgPwdPeriod);
		
		int day = CommonUtil.daysOfTwo(before, after);
		
		if(day < 30 && day > 0) {
			memo = memo + "密碼剩" + day + "\n";
		} else if(day < 1) {
			memo = memo + "密碼到期\n";
		}
		
		userVO.setMemo(memo);
	}
	
	

}
