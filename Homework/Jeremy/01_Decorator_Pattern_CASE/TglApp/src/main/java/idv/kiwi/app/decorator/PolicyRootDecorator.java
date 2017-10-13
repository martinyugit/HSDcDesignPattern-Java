package idv.kiwi.app.decorator;

import idv.kiwi.app.vo.UserVO;

public abstract class PolicyRootDecorator implements IPolicyRoot {
	/** */
	private static final long serialVersionUID = -3274992747306843636L;
	protected IPolicyRoot policyRoot;
	
	public PolicyRootDecorator(IPolicyRoot policyRoot) {
		this.policyRoot = policyRoot;
	}
	
	public abstract void passSecurityCheck(UserVO userVO);
}
