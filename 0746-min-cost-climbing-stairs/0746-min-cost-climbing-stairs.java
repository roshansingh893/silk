class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return solve(n, cost, dp);
    }

    public int solve(int n, int[] cost, int[] dp) {
        if (n <= 1) {
            return 0;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int oneStep =
            solve(n - 1, cost, dp) + cost[n - 1];

        int twoStep =
            solve(n - 2, cost, dp) + cost[n - 2];

        return dp[n] = Math.min(oneStep, twoStep);
    }
}