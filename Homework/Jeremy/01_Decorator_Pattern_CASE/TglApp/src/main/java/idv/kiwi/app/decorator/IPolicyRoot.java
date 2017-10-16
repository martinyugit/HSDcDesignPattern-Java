package idv.kiwi.app.decorator;

import java.io.Serializable;

import idv.kiwi.app.vo.UserVO;

public interface IPolicyRoot extends Serializable {
	public void passSecurityCheck(UserVO userVO);
}
