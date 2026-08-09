class Solution {

    public int maxProfit(int[] prices) {

        int n = prices.length;

        Integer[][] dp = new Integer[n][2];

        return solve(0, 1, prices, dp);
    }

    private int solve(int day,
                      int buy,
                      int[] prices,
                      Integer[][] dp) {

        if (day >= prices.length) {
            return 0;
        }

        if (dp[day][buy] != null) {
            return dp[day][buy];
        }

        int ans;

        if (buy == 1) {

            ans = Math.max(
                -prices[day] +
                solve(day + 1, 0, prices, dp),

                solve(day + 1, 1, prices, dp)
            );

        } else {

            ans = Math.max(
                prices[day] +
                solve(day + 2, 1, prices, dp),

                solve(day + 1, 0, prices, dp)
            );
        }

        return dp[day][buy] = ans;
    }
}