import java.util.*;

class Solution {
    public int evalRPN(String[] tokens) {

        Queue<String> q = new LinkedList<>();

        for (String token : tokens) {
            q.offer(token);
        }

        Stack<Integer> st = new Stack<>();

        while (!q.isEmpty()) {

            String token = q.poll();

            if (token.equals("+") || token.equals("-") ||
                token.equals("*") || token.equals("/")) {

                int b = st.pop();
                int a = st.pop();

                if (token.equals("+")) {
                    st.push(a + b);
                } else if (token.equals("-")) {
                    st.push(a - b);
                } else if (token.equals("*")) {
                    st.push(a * b);
                } else {
                    st.push(a / b);
                }

            } else {
                st.push(Integer.parseInt(token));
            }
        }

        return st.pop();
    }
}