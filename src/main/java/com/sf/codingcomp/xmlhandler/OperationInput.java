package com.sf.codingcomp.xmlhandler;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;


public class OperationInput implements Serializable{
	private static final long serialVersionUID = -698495616369324236L;
	

	private String employeeID;
	
	public String getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

}
