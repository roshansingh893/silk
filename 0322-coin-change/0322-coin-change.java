class Solution {
    public int coinChange(int[] coins, int amount) {
       
        int n = coins.length;

        int[][] dp = new int[n][amount + 1];

        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int ans = solve(0, amount,  dp , coins);

      return ans >= 100000 ? -1 : ans;
    }

    // dp state is ith idx with this much amount left;

    public int solve(int i , int amount , int[][] dp , int[] coins){
        if(amount == 0){
            return 0;
        }
if(i == coins.length){
    return 1000000; // impossible
}
        if(dp[i][amount] != -1){
            return dp[i][amount];
        }
        int take = 100000;

      if( coins[i] <= amount){
          take = 1 + solve(i , amount - coins[i] , dp , coins);
      }

     int not = solve(i + 1 , amount , dp , coins);

      return dp[i][amount] = Math.min(take , not);
    }

    
}