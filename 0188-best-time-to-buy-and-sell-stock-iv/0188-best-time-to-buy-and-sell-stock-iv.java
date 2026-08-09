class Solution {

    public int maxProfit(int k, int[] prices) {

        int n = prices.length;

        if (k >= n / 2) {
            int profit = 0;

            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }

            return profit;
        }

        Integer[][][] dp = new Integer[n][2][k + 1];

        return solve(0, 1, k, prices, dp);
    }

    private int solve(int day,
                      int buy,
                      int cap,
                      int[] prices,
                      Integer[][][] dp) {

        if (day == prices.length || cap == 0) {
            return 0;
        }

        if (dp[day][buy][cap] != null) {
            return dp[day][buy][cap];
        }

        int ans;

        if (buy == 1) {

            ans = Math.max(
                -prices[day] +
                solve(day + 1, 0, cap, prices, dp),

                solve(day + 1, 1, cap, prices, dp)
            );

        } else {

            ans = Math.max(
                prices[day] +
                solve(day + 1, 1, cap - 1, prices, dp),

                solve(day + 1, 0, cap, prices, dp)
            );
        }

        return dp[day][buy][cap] = ans;
    }
}