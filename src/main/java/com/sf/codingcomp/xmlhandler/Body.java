package com.sf.codingcomp.xmlhandler;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;


public class Body implements Serializable{
	private static final long serialVersionUID = -8215145975692877656L;

	
	private OperationInput operationInput = new OperationInput();

	private Benefits benefits;
	
	public OperationInput getOperationInput() {
		return operationInput;
	}
	public void setOperationInput(OperationInput operationInput) {
		this.operationInput = operationInput;
	}
	public Benefits getBenefits() {
		return benefits;
	}
	public void setBenefits(Benefits benefits) {
		this.benefits = benefits;
	}
		
	
}
