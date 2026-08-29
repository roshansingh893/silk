class Solution {

    public List<List<Integer>> generate(int numRows) {
        int[][] dp = new int[numRows][numRows];

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                row.add(solve(i, j, dp));
            }

            ans.add(row);
        }

        return ans;
    }

    public int solve(int i, int j, int[][] dp) {

        if (j == 0 || j == i) {
            return 1;
        }

        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        return dp[i][j] =
                solve(i - 1, j - 1, dp)
              + solve(i - 1, j, dp);
    }
}