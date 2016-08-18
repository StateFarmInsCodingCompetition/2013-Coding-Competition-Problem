package com.sf.codingcomp.tweet;

public class Hashtag {

	private String text;
	private int occurrences;

	public Hashtag(String text, Integer occurrences) {
		this.text = text;
		this.occurrences = occurrences;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getOccurrences() {
		return occurrences;
	}

	public void setOccurrences(int occurrences) {
		this.occurrences = occurrences;
	}

}
