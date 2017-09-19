package com.hsdc.dp.intf.dto.builder;

import java.io.Serializable;
import java.util.Date;

public class Leave implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -380920585101902853L;
	
	private String leaveID;
    private String applier;
    private String leaveType;
    private int leaveDay;
    private Date leaveBeginDate;
    
    public String getLeaveID() {
		return leaveID;
	}
	public void setLeaveID(String leaveID) {
		this.leaveID = leaveID;
	}
	public String getApplier() {
		return applier;
	}
	public void setApplier(String applier) {
		this.applier = applier;
	}
	public String getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	public int getLeaveDay() {
		return leaveDay;
	}
	public void setLeaveDay(int leaveDay) {
		this.leaveDay = leaveDay;
	}
	public Date getLeaveBeginDate() {
		return leaveBeginDate;
	}
	public void setLeaveBeginDate(Date leaveBeginDate) {
		this.leaveBeginDate = leaveBeginDate;
	}

}
