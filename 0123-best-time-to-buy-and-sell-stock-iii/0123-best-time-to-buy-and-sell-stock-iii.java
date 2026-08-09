class Solution {

    public int maxProfit(int[] prices) {

        int n = prices.length;

        Integer[][][] dp = new Integer[n][2][3];

        return solve(0, 1, 2, prices, dp);
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

        int profit;

        if (buy == 1) {

            profit = Math.max(
                -prices[day] +
                solve(day + 1, 0, cap, prices, dp),

                solve(day + 1, 1, cap, prices, dp)
            );

        } else {

            profit = Math.max(
                prices[day] +
                solve(day + 1, 1, cap - 1, prices, dp),

                solve(day + 1, 0, cap, prices, dp)
            );
        }

        return dp[day][buy][cap] = profit;
    }
}