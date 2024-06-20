package leetcode.priorityqueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Twitter {
	public static void main(String args[]) {
		Twitter twitter = new Twitter();
		twitter.postTweet(1, 5);
		twitter.postTweet(1, 3);
		twitter.postTweet(1, 101);
		twitter.postTweet(1, 13);
		twitter.postTweet(1, 10);
		twitter.postTweet(1, 2);
		twitter.postTweet(1, 94);
		twitter.postTweet(1, 505);
		twitter.postTweet(1, 333);
		twitter.postTweet(1, 22);
		twitter.postTweet(1, 11);
		twitter.getNewsFeed(1);

	}

    public class User{
        int userId;
        Set<Integer> followers;
        public User(int userId){
            this.userId = userId;
            followers = new HashSet<Integer>();
            followers.add(userId);
        }
        void followUser(int userId){
        	followers.add(userId);
        }
        void unfollowUser(int userId){
        	followers.remove(userId);
        }
    }

    public class Tweet{
        int tweetId;
        int timestamp;
        public Tweet(int tweetId){
            this.tweetId = tweetId;
            this.timestamp = count;
            count++;
        }
    }
        int count;
        HashMap<Integer,List<Tweet>> tweets;
        HashMap<Integer,User> user_list;
    public Twitter() {
        tweets = new HashMap<Integer,List<Tweet>>();
        user_list = new HashMap<Integer,User>();
        count = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        List<Tweet> lst;
        User user = user_list.get(userId);
        if(user == null){
             user_list.put(userId,new User(userId));
        }
        if(tweets.containsKey(userId)){
            lst = tweets.get(userId);
            lst.add(new Tweet(tweetId));
        }
        else{
             lst = new ArrayList<Tweet>();
            Tweet tweet = new Tweet(tweetId);
            lst.add(tweet);
        }
            tweets.put(userId,lst);

    }
    
    public List<Integer> getNewsFeed(int userId) {
    	PriorityQueue<Integer> newsfeed = new PriorityQueue<Integer>();
    	List<Integer> res = new ArrayList<>();
    	User user = user_list.get(userId);
    	PriorityQueue<Tweet> min_heap = new PriorityQueue<>(10,((a,b)->Integer.compare(a.timestamp, b.timestamp)));
    	if(user == null) return res;
    	for(Integer id : user.followers) {
    		List<Tweet> lst = tweets.getOrDefault(id, new ArrayList<Tweet>());
    		for(Tweet tweet : lst) {
    	   		if(min_heap.size()<10) {
        			min_heap.offer(tweet);
        		}
    	   		else {
                    if(min_heap.peek().timestamp<tweet.timestamp) {
    	   			min_heap.poll();
    	   			min_heap.offer(tweet);}
    	   		}
    	   		
    		}
 
    	}
    	while(!min_heap.isEmpty()) {
    		res.add(min_heap.poll().tweetId);
    	}
        Collections.reverse(res);
    	return res;
    }
    
    public void follow(int followerId, int followeeId) {
        User user = user_list.getOrDefault(followerId, new User(followerId));
            user.followUser(followeeId);
            user_list.put(followerId,user);
    }
    
    public void unfollow(int followerId, int followeeId) {
         User user = user_list.get(followerId);
        if(user!=null)
            user.unfollowUser(followeeId);
    }
}
