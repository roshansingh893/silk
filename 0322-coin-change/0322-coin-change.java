class Solution {

    public int coinChange(int[] coins, int amount) {

        int[][] dp = new int[coins.length][amount + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int ans = solve(0, amount, coins, dp);

        return ans >= 1000000000 ? -1 : ans;
    }

    private int solve(int i, int amount, int[] coins, int[][] dp) {

        if (amount == 0) {
            return 0;
        }

        if (i == coins.length) {
            return 1000000000;
        }

        if (dp[i][amount] != -1) {
            return dp[i][amount];
        }

        int take = 1000000000;

        if (coins[i] <= amount) {
            take = 1 + solve(i, amount - coins[i], coins, dp);
        }

        int notTake = solve(i + 1, amount, coins, dp);

        return dp[i][amount] = Math.min(take, notTake);
    }
}