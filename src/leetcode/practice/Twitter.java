package leetcode.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class Twitter {
    class User{
        int uid;
        HashSet<Integer> following;
        List<Integer> tweets;
        User(int uid){
        	this.uid = uid;
        	this.following = new HashSet<Integer>();
        	this.tweets = new ArrayList<Integer>();
        }
    }

    HashMap<Integer, User> user_db;
    public Twitter() {
        user_db = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(user_db.containsKey(userId)){
        
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
    	return null;
    }
    
    public void follow(int followerId, int followeeId) {
    }
    
    public void unfollow(int followerId, int followeeId) {
        
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
