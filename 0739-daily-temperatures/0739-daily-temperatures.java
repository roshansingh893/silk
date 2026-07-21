class Solution {
    class Pair {
        int idx;
        int val;

        Pair(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }

    public int[] dailyTemperatures(int[] temp) {
        Stack<Pair> st = new Stack<>();
        int[] ans = new int[temp.length];

        for (int i = 0; i < temp.length; i++) {

            while (!st.isEmpty() && st.peek().val < temp[i]) {
                Pair p = st.pop();
                ans[p.idx] = i - p.idx;
            }

            st.push(new Pair(i, temp[i]));
        }

        return ans;
    }
}