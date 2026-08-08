class Solution {

    public int lengthOfLIS(int[] nums) {

        int n = nums.length;
        int[] dp = new int[n];

        Arrays.fill(dp, -1);

        int ans = 0;

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, solve(i, nums, dp));
        }

        return ans;
    }

    private int solve(int i, int[] nums, int[] dp) {

        if (dp[i] != -1) {
            return dp[i];
        }

        int lis = 1;

        for (int j = i + 1; j < nums.length; j++) {

            if (nums[j] > nums[i]) {
                lis = Math.max(lis,
                               1 + solve(j, nums, dp));
            }
        }

        return dp[i] = lis;
    }
}