class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp , -1); 

        return solve(nums , n , dp);
    }
     
    public int solve(int[] nums , int n , int[] dp){
        if(n < 1){
            return 0;
        }

        if(dp[n] != -1){
            return dp[n];
        }
        int take = nums[n-1] + solve(nums , n - 2 , dp);
        int not = solve(nums , n-1 , dp);

        return dp[n] = Math.max(take , not);
    }
}