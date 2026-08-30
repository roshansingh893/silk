class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] row : dp){
            Arrays.fill(row , -1);
        }

        return solve(0 , 0 , dp , m , n);
    }

    public int solve(int i , int j , int[][] dp , int m , int n){
        if(i < 0 || i >= m || j < 0 || j >= n){
            return 0;
        }

        if(i == m -1 && j == n -1) return 1;

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int right = solve(i , j + 1 , dp , m , n);
        int down = solve(i +1 ,  j , dp , m , n);

        return dp[i][j] = right + down;
    }
}