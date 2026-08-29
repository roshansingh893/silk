class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(0, n, dp);
    }

    int solve(int curr, int n, int[] dp) {
        if (curr == n) return 1; 
        if (curr > n) return 0;  

        if (dp[curr] != -1) return dp[curr];

        return dp[curr] =
                solve(curr + 1, n, dp) +
                solve(curr + 2, n, dp);
    }
}