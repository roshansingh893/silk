class Solution {

    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack("", 0, 0, n);
        return ans;
    }

    private void backtrack(String cur, int open, int close, int n) {

        if (cur.length() == 2 * n) {
            ans.add(cur);
            return;
        }

        if (open < n)
            backtrack(cur + "(", open + 1, close, n);

        if (close < open)
            backtrack(cur + ")", open, close + 1, n);
    }
}