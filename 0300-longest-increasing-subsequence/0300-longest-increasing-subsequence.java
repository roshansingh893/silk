class Solution {
    public int lengthOfLIS(int[] nums) {
          int n = nums.length;
          int[] dp = new int[n];
          Arrays.fill(dp , -1);
          int max = 0;

          for(int i = 0; i < n; i++){
             max = Math.max(max , solve(i , dp ,nums));
          }

          return max;
    }

    public int solve(int i , int[] dp , int[] nums){
       //    if(i == nums.length) return 0;

           if(dp[i] != -1) return dp[i];

           int lis = 1;

           for(int j = i + 1; j < nums.length; j++){
              if(nums[j] > nums[i]) {
               lis = Math.max(lis , 1 + solve(j , dp , nums));
               }
           }
       return dp[i] = lis;
    }
}