package com.sf.codingcomp.tweet;

import java.util.ArrayList;
import java.util.List;

public class Feed {

	private List<Tweet> tweets = new ArrayList<Tweet>();

	public List<Tweet> getTweets() {
		return tweets;
	}

	public void setTweets(List<Tweet> tweets) {
		this.tweets = tweets;
	}

}
