class Solution {

    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;

        int[][] dp = new int[nums.length][target + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, target, nums, dp);
    }

    private boolean solve(int i, int target, int[] nums, int[][] dp) {

        if (target == 0) {
            return true;
        }

        if (i == nums.length || target < 0) {
            return false;
        }

        if (dp[i][target] != -1) {
            return dp[i][target] == 1;
        }

        boolean take = solve(i + 1, target - nums[i], nums, dp);

        boolean notTake = solve(i + 1, target, nums, dp);

        dp[i][target] = (take || notTake) ? 1 : 0;

        return take || notTake;
    }
}