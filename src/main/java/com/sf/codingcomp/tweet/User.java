package com.sf.codingcomp.tweet;

public class User {

	public String username;
	public Feed feed = new Feed();

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Feed getFeed() {
		return feed;
	}

	public void setFeed(Feed feed) {
		this.feed = feed;
	}

	public void follow(User user) {
		// TODO implement me
	}

	public void unfollow(User user) {
		// TODO implement me
	}

	public String toString() {
		return username;
	}

}
