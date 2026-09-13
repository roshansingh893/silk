class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {

        Boolean[] dp = new Boolean[s.length()];

        return solve(0, s, new HashSet<>(wordDict), dp);
    }

    private boolean solve(int start, String s,
                          Set<String> dict,
                          Boolean[] dp) {

        if (start == s.length()) {
            return true;
        }

        if (dp[start] != null) {
            return dp[start];
        }

        for (int end = start + 1; end <= s.length(); end++) {

            String sub = s.substring(start, end);

            if (dict.contains(sub)) {

                if (solve(end, s, dict, dp)) {
                    return dp[start] = true;
                }
            }
        }

        return dp[start] = false;
    }
}