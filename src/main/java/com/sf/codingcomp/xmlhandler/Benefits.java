package com.sf.codingcomp.xmlhandler;

import java.io.Serializable;
import com.thoughtworks.xstream.annotations.XStreamAlias;


public class Benefits implements Serializable{
	
	private static final long serialVersionUID = 1403066849582942195L;
	
	
	private String employeeID = "";

	private EmployeeInfo employeeInfo = new EmployeeInfo();
	
	private RetirementAccounts retirementAccounts = new RetirementAccounts();
	

	public String getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}
	public EmployeeInfo getEmployeeInfo() {
		return employeeInfo;
	}
	public void setEmployeeInfo(EmployeeInfo employeeInfo) {
		this.employeeInfo = employeeInfo;
	}
	public RetirementAccounts getRetirementAccounts() {
		return retirementAccounts;
	}
	public void setRetirementAccounts(RetirementAccounts retirementAccounts) {
		this.retirementAccounts = retirementAccounts;
	}
	
	
	
}
