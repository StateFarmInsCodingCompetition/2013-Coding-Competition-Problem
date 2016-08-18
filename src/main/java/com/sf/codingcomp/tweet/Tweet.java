package com.sf.codingcomp.tweet;

public class Tweet {

	private String text;
	private User author;

	public Tweet(String text, User author) {
		this.text = text;
		this.author = author;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

}
