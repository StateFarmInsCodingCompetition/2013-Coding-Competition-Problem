package com.sf.codingcomp.xmlhandler;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;


public class Header implements Serializable{
	private static final long serialVersionUID = 8237162654660345555L;
	
	
	private String service = "";

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	
	
}
