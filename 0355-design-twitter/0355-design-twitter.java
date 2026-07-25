import java.util.*;

class Twitter {

    class Tweet {
        int tweetId;
        int time;

        Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    class User {
        int id;
        List<Tweet> tweets;
        Set<Integer> following;

        User(int id) {
            this.id = id;
            tweets = new ArrayList<>();
            following = new HashSet<>();
        }
    }

    Map<Integer, User> users;
    int time;

    public Twitter() {
        users = new HashMap<>();
        time = 0;
    }

    private User getOrCreateUser(int id) {
        if (!users.containsKey(id)) {
            users.put(id, new User(id));
        }
        return users.get(id);
    }

    public void postTweet(int userId, int tweetId) {
        User user = getOrCreateUser(userId);
        user.tweets.add(new Tweet(tweetId, time++));
    }

    public List<Integer> getNewsFeed(int userId) {

        List<Integer> ans = new ArrayList<>();

        if (!users.containsKey(userId))
            return ans;

        User user = users.get(userId);

        PriorityQueue<Tweet> pq =
                new PriorityQueue<>((a, b) -> b.time - a.time);

        // Add my tweets
        for (Tweet t : user.tweets)
            pq.offer(t);

        // Add tweets of everyone I follow
        for (int followee : user.following) {
            User u = users.get(followee);

            if (u == null)
                continue;

            for (Tweet t : u.tweets)
                pq.offer(t);
        }

        while (!pq.isEmpty() && ans.size() < 10) {
            ans.add(pq.poll().tweetId);
        }

        return ans;
    }

    public void follow(int followerId, int followeeId) {

        if (followerId == followeeId)
            return;

        User follower = getOrCreateUser(followerId);
        getOrCreateUser(followeeId);

        follower.following.add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {

        if (!users.containsKey(followerId))
            return;

        users.get(followerId).following.remove(followeeId);
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