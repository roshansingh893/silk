class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp , -1);
        return solve(n , dp);
    }
    public int solve(int i , int[] dp){
       if(i <= 1){
          return 1;
       }

       if(dp[i] != -1){
         return dp[i];
       }

       return dp[i] = solve(i-1 , dp) + solve(i-2 , dp );
    }
}