class RecentCounter {
    Deque<Integer> recentRequests;
    public RecentCounter() {
        recentRequests = new ArrayDeque<>();
    }
    
    public int ping(int t) {
        recentRequests.offer(t);
        int windowStart = t - 3000;

        while(!recentRequests.isEmpty() && recentRequests.peek() < windowStart){
            recentRequests.poll();
        }

        return recentRequests.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */