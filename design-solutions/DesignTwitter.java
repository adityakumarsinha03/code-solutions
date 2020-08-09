class Twitter {

    Map<Integer, Set<Integer> > followMap;
    Map<Integer, HashMap<Integer, Integer> > tweetMap;
    
    int timeStamp = 0;
    /** Initialize your data structure here. */
    public Twitter() {
        this.followMap = new HashMap<>();
        this.tweetMap = new HashMap<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        timeStamp++;
        HashMap<Integer, Integer> tMap = tweetMap.get(userId);
        if(tMap == null)
            tMap = new HashMap<Integer, Integer>();
        
        tMap.put(timeStamp, tweetId);
        tweetMap.put(userId, tMap);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> followerList = followMap.get(userId);
        
        List<Integer> newsFeed = new ArrayList<>();
        
		// Max PriorityQueue to store <timeStamp, tweetId>
        PriorityQueue<Pair<Integer, Integer> > pq = new PriorityQueue(10,
            new Comparator<Pair<Integer, Integer> >() {
                public int compare(Pair<Integer, Integer> a1, Pair<Integer, Integer> a2) {
                    return  ((a2.getKey() > a1.getKey())? 1: ((a2.getKey() ==a1.getKey()) ? 0 : -1));
                }
        });
        
		// Add all the tweets of the user to PriorityQueue
        if(tweetMap.get(userId) != null)
            pq = getRecentTweets(tweetMap.get(userId), pq);
		
		// Add all the tweets of the user's followee to PriorityQueue
        if(followerList != null){
            for(Integer follower : followerList){
                if(tweetMap.get(follower) != null)
                    pq = getRecentTweets(tweetMap.get(follower), pq);
            }
        }
        
        int countOfTweets = 10;
        Pair<Integer, Integer> pair;
        while((pair = pq.poll()) != null && countOfTweets>0) {
            newsFeed.add(pair.getValue());
            countOfTweets--;
        }
        return newsFeed;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId)
            return;
        Set<Integer> followerList = followMap.get(followerId);
        if(followerList == null)
            followerList = new HashSet<>();
        
        followerList.add(followeeId);
        followMap.put(followerId, followerList);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followerList = followMap.get(followerId);
        if(followerList == null || followerList.size() == 0)
            return;
        
        followerList = followMap.get(followerId);
        followerList.remove(new Integer(followeeId));
        followMap.put(followerId, followerList);
    }
    
    public PriorityQueue<Pair<Integer, Integer> > getRecentTweets(Map<Integer, Integer> mp, PriorityQueue<Pair<Integer, Integer> > pq){
        for (Map.Entry<Integer,Integer> entry : mp.entrySet())
            pq.offer(new Pair<Integer, Integer>(entry.getKey(), entry.getValue()));
        return pq;
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