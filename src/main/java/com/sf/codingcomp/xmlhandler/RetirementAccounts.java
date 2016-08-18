package com.sf.codingcomp.xmlhandler;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;


public class RetirementAccounts implements Serializable{

	private static final long serialVersionUID = 5888582895726625710L;
	
	private String rothIRABalance = "";
	
	private String pensionBalance = "";

	public String getRothIRABalance() {
		return rothIRABalance;
	}
	public void setRothIRABalance(String rothIRABalance) {
		this.rothIRABalance = rothIRABalance;
	}
	public String getPensionBalance() {
		return pensionBalance;
	}
	public void setPensionBalance(String pensionBalance) {
		this.pensionBalance = pensionBalance;
	}
	
	
	
}
