package idv.kiwi.app.vo;

public class UserVO {
	private String userId;
	private String userName;
	private String userPwd;
	private String userType;
	private String userStatus;
	private java.util.Date lastLogonDate;
	private java.util.Date pwdChgDate;
	private int duringChgPwdPeriod;
	private String memo;
	
	public UserVO() {}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public java.util.Date getLastLogonDate() {
		return lastLogonDate;
	}

	public void setLastLogonDate(java.util.Date lastLogonDate) {
		this.lastLogonDate = lastLogonDate;
	}

	public java.util.Date getPwdChgDate() {
		return pwdChgDate;
	}

	public void setPwdChgDate(java.util.Date pwdChgDate) {
		this.pwdChgDate = pwdChgDate;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public int getDuringChgPwdPeriod() {
		return duringChgPwdPeriod;
	}

	public void setDuringChgPwdPeriod(int duringChgPwdPeriod) {
		this.duringChgPwdPeriod = duringChgPwdPeriod;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	
	
}
