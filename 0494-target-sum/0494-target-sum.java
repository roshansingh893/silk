class Solution {

    public int findTargetSumWays(int[] nums, int target) {

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (Math.abs(target) > sum || (sum + target) % 2 != 0) {
            return 0;
        }

        int req = (sum + target) / 2;

        int[][] dp = new int[nums.length][req + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, req, nums, dp);
    }

    private int solve(int i, int target,
                      int[] nums,
                      int[][] dp) {

     if (i == nums.length) {
            return target == 0 ? 1 : 0;
        }

        if (i == nums.length) {
            return 0;
        }

        if (dp[i][target] != -1) {
            return dp[i][target];
        }

        int take = 0;

        if (nums[i] <= target) {
            take = solve(i + 1,
                         target - nums[i],
                         nums,
                         dp);
        }

        int notTake = solve(i + 1,
                            target,
                            nums,
                            dp);

        return dp[i][target] = take + notTake;
    }
}