package com.sf.codingcomp.xmlhandler;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;


public class Input implements Serializable{

	private static final long serialVersionUID = -3138397684178539868L;
	

	private Header header = new Header();
	
	private Body body = new Body();

	public Header getHeader() {
		return header;
	}
	public void setHeader(Header header) {
		this.header = header;
	}
	public Body getBody() {
		return body;
	}
	public void setBody(Body body) {
		this.body = body;
	}
	
	
}
