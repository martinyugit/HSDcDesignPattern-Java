package com.hsdc.dp.intf.dto.builder;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ApplyExpenseDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7141912051111158865L;
	
	private String ReferenceNumber;
    private Date OccureDate;
    private BigDecimal Expense;
	public String getReferenceNumber() {
		return ReferenceNumber;
	}
	public void setReferenceNumber(String referenceNumber) {
		ReferenceNumber = referenceNumber;
	}
	public Date getOccureDate() {
		return OccureDate;
	}
	public void setOccureDate(Date occureDate) {
		OccureDate = occureDate;
	}
	public BigDecimal getExpense() {
		return Expense;
	}
	public void setExpense(BigDecimal expense) {
		Expense = expense;
	}

}
