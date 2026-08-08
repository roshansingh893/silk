class Solution {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, 0, m, n, dp);
    }

    private int solve(int i, int j, int m, int n, int[][] dp) {

        if (i == m - 1 && j == n - 1) {
            return 1;
        }
        if (i >= m || j >= n) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int down = solve(i + 1, j, m, n, dp);
        int right = solve(i, j + 1, m, n, dp);

        return dp[i][j] = down + right;
    }
}