package com.sf.codingcomp.xmlhandler;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;


public class Output implements Serializable{

	private static final long serialVersionUID = -6663862003665891011L;
	
	private String service = "";
	
	private Body body = new Body();
	
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public Body getBody() {
		return body;
	}
	public void setBody(Body body) {
		this.body = body;
	}
	
	
}
