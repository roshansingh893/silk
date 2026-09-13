class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for(int[] ar : dp){
            Arrays.fill(ar , -1);
        }


        return solve(dp , m  , n , 0 , 0);         
      
    }

    public int solve(int[][] dp , int m , int n , int i , int j){
        

         if(i < 0 || i >= m || j < 0 || j >= n){
             return 0;
         }

         if(i == m - 1 && j == n - 1){
            return 1;
         }
          if(dp[i][j] != -1){
            return dp[i][j];
         }


         int down = solve(dp , m , n , i + 1 , j);
         int right = solve(dp  , m , n , i , j + 1);

         return dp[i][j] = down + right;
    }
}