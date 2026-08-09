class Solution {

    public int maxProfit(int[] prices, int fee) {

        Integer[][] dp = new Integer[prices.length][2];

        return solve(0, 1, prices, fee, dp);
    }

    private int solve(int day,
                      int buy,
                      int[] prices,
                      int fee,
                      Integer[][] dp) {

        if (day == prices.length) {
            return 0;
        }

        if (dp[day][buy] != null) {
            return dp[day][buy];
        }

        int ans;

        if (buy == 1) {

            ans = Math.max(
                -prices[day] +
                solve(day + 1, 0, prices, fee, dp),

                solve(day + 1, 1, prices, fee, dp)
            );

        } else {

            ans = Math.max(
                prices[day] - fee +
                solve(day + 1, 1, prices, fee, dp),

                solve(day + 1, 0, prices, fee, dp)
            );
        }

        return dp[day][buy] = ans;
    }
}