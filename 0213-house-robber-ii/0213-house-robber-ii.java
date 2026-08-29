class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];
        Arrays.fill(dp1 , -1);
        Arrays.fill(dp2 , -1);
        int a = solve(0 , n - 2 , dp1 , nums  );
        int b = solve( 1 , n-1 , dp2 , nums);
        return Math.max(a ,b);
    }

    public int solve(int i , int j , int[] dp , int[] nums){
        if(i > j){
           return 0;
        }

        if(dp[i] != -1){
            return dp[i];
        }

        int take = nums[i] + solve(i + 2 , j , dp , nums);
        int not = solve(i + 1 , j , dp , nums);

        return dp[i] = Math.max(take , not);
    }
}