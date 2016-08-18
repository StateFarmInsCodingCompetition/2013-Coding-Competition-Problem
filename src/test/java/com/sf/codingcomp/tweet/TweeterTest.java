//
//Do not change anything in the following JAVA class!
//
package com.sf.codingcomp.tweet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
//
//Do not change anything in the following JAVA class!
//

public class TweeterTest {

	private Tweeter tweeter;
	private User sf;
	private User mayhem;
	private User gecko;

	@Before
	public void setup() {
		tweeter = new Tweeter();
		sf = new User();
		sf.setUsername("statefarm");
		mayhem = new User();
		mayhem.setUsername("mayhem");
		gecko = new User();
		gecko.setUsername("gecko");
	}

	@Test
	public void tweetTooLong() {
		try {
			tweeter.tweet(
					"Cookie?  #homemade #chocolatechip #delicious #dontmindifidont #gettingmycookieon #iamtherealcookiemonster #nomnomnom #lololololololololololololol",
					sf);
			fail("Tweet should be too long");
		} catch (TweetTooLongException e) {
			// success
		}
	}

	@Test
	public void userMentionsSelf() throws Exception {
		mayhem.follow(sf);
		sf.follow(mayhem);

		tweeter.tweet("2013 @statefarm coding competition is happening now.  #java #codingcomp #mayhem", sf);
		assertEquals(0, tweeter.findMentions(sf).size());
		assertEquals(1, tweeter.findMentions(mayhem).size());
		assertEquals("@statefarm", tweeter.findMentions(mayhem).get(0));
	}

	@Test
	public void userMentionsAnotherUser() throws Exception {
		mayhem.follow(sf);
		sf.follow(mayhem);

		tweeter.tweet("@mayhem Get coding!  #java #codingcomp #statefarm", sf);
		assertEquals(0, tweeter.findMentions(mayhem).size());
		assertEquals(1, tweeter.findMentions(sf).size());
		assertEquals("@mayhem", tweeter.findMentions(sf).get(0));
	}

	@Test
	public void userMentionsMultipleUsers() throws Exception {
		mayhem.follow(sf);
		mayhem.follow(gecko);
		sf.follow(mayhem);
		sf.follow(gecko);
		sf.unfollow(gecko);
		gecko.follow(mayhem);
		gecko.follow(sf);

		tweeter.tweet("@statefarm @mayhem Refactor your code!  #java #codingcomp", gecko);
		assertEquals(1, tweeter.findMentions(mayhem).size());
		assertEquals("@statefarm", tweeter.findMentions(mayhem).get(0));
		assertEquals(2, tweeter.findMentions(gecko).size());
		assertEquals("@mayhem", tweeter.findMentions(gecko).get(0));
		assertEquals("@statefarm", tweeter.findMentions(gecko).get(1));
		assertEquals(0, tweeter.findMentions(sf).size());
	}
	
	@Test
	public void mostTweets() throws Exception {
		tweeter.tweet("avoid me", mayhem);
		tweeter.tweet("avoid me", mayhem);
		tweeter.tweet("avoid me", mayhem);
		assertNull(tweeter.findMostActiveFollower(gecko));
		
		sf.follow(gecko);
		mayhem.follow(gecko);
		tweeter.tweet("2013 @statefarm coding competition is happening now.  #java #codingcomp #mayhem", sf);
		tweeter.tweet("2013 @statefarm coding competition is happening now.  #java #codingcomp #mayhem", sf);
		assertNotNull(tweeter.findMostActiveFollower(gecko));
		assertEquals(mayhem, tweeter.findMostActiveFollower(gecko));
		
	}
	
	@Test
	public void mostPopularHashtags() throws Exception {
		gecko.follow(sf);
		gecko.follow(mayhem);
		
		tweeter.tweet("avoid me #advice", mayhem);
		tweeter.tweet("avoid me #advice", mayhem);
		tweeter.tweet("avoid me #advice", mayhem);
		tweeter.tweet("avoid me #advice", mayhem);
		tweeter.tweet("2013 @statefarm coding competition is happening now.  #java #codingcomp #mayhem", sf);
		tweeter.tweet("2013 @statefarm coding competition is happening now.  #java", sf);
		tweeter.tweet("@statefarm @mayhem Refactor your code!  #java #codingcomp", gecko);
		
		assertEquals(3, tweeter.findMostPopularHashtags(gecko, 3).size());
		assertEquals(4, tweeter.findMostPopularHashtags(gecko, 10).size());
		assertEquals("#advice", tweeter.findMostPopularHashtags(gecko, 3).get(0).getText());
		assertEquals("#java", tweeter.findMostPopularHashtags(gecko, 3).get(1).getText());
		assertEquals("#codingcomp", tweeter.findMostPopularHashtags(gecko, 3).get(2).getText());
	}
	@Test
	public void mostRecentTweets() throws Exception {
		User sf = new User();
		sf.setUsername("statefarm");
		
		tweeter.tweet("@cooking #iamtherealcookiemonster #nomnomnom #lololololololololololololol", sf);
		tweeter.tweet("@statefarm @mayhem Refactor your code!  #java #codingcomp", sf);
		tweeter.tweet("@mayhem Get coding!  #java #codingcomp #statefarm", sf);
		tweeter.tweet("@Goose #iamtherealcookiemonster #nomnomnom #lololololololololololololol", sf);
		tweeter.tweet("@OhNo @mayhem Refactor your code!  #java #codingcomp", sf);
		tweeter.tweet("@Flush Get coding!  #java #codingcomp #statefarm", sf);
		
		assertEquals("@Flush Get coding!  #java #codingcomp #statefarm",tweeter.findMostRecentTweets(sf,1).get(0).getText());
		assertEquals("@Goose #iamtherealcookiemonster #nomnomnom #lololololololololololololol",tweeter.findMostRecentTweets(sf,3).get(2).getText());
		assertEquals("@cooking #iamtherealcookiemonster #nomnomnom #lololololololololololololol",tweeter.findMostRecentTweets(sf,6).get(5).getText());
		assertEquals("@cooking #iamtherealcookiemonster #nomnomnom #lololololololololololololol",tweeter.findMostRecentTweets(sf,78).get(5).getText());
	}


}
