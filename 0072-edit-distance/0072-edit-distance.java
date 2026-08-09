class Solution {

    public int minDistance(String word1,
                           String word2) {

        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, 0, word1, word2, dp);
    }

    private int solve(int i,
                      int j,
                      String word1,
                      String word2,
                      int[][] dp) {

        int m = word1.length();
        int n = word2.length();

        if (i == m) {
            return n - j;
        }

        if (j == n) {
            return m - i;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (word1.charAt(i) == word2.charAt(j)) {

            return dp[i][j] =
                solve(i + 1,
                      j + 1,
                      word1,
                      word2,
                      dp);
        }

        int insert =
            1 + solve(i,
                      j + 1,
                      word1,
                      word2,
                      dp);

        int delete =
            1 + solve(i + 1,
                      j,
                      word1,
                      word2,
                      dp);

        int replace =
            1 + solve(i + 1,
                      j + 1,
                      word1,
                      word2,
                      dp);

        return dp[i][j] = Math.min(
            insert,
            Math.min(delete, replace)
        );
    }
}