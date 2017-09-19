package com.hsdc.dp.intf.dto.builder;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class ApplyExpense implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7527529781462663572L;
	
	private String applyExpenseID;
    private String applier;
    private String applyExpenseType;
    private Date applyDate;
    private List<ApplyExpenseDetail> lineItems;
	public String getApplyExpenseID() {
		return applyExpenseID;
	}
	public void setApplyExpenseID(String applyExpenseID) {
		this.applyExpenseID = applyExpenseID;
	}
	public String getApplier() {
		return applier;
	}
	public void setApplier(String applier) {
		this.applier = applier;
	}
	public String getApplyExpenseType() {
		return applyExpenseType;
	}
	public void setApplyExpenseType(String applyExpenseType) {
		this.applyExpenseType = applyExpenseType;
	}
	public Date getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}
	public List<ApplyExpenseDetail> getLineItems() {
		return lineItems;
	}
	public void setLineItems(List<ApplyExpenseDetail> lineItems) {
		this.lineItems = lineItems;
	}
	public BigDecimal getTotalExpense() {
		BigDecimal exp = BigDecimal.ZERO;
		if (this.lineItems != null)
			for (ApplyExpenseDetail d : lineItems)
				exp.add(d.getExpense());
		return exp;
	}

}
