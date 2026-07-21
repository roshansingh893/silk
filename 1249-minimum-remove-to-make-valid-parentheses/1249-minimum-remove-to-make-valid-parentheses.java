import java.util.Stack;



class Solution {

    public String minRemoveToMakeValid(String s) {



        Stack<Integer> st = new Stack<>();

        int[] rem = new int[s.length()];



        // First pass: mark invalid ')'

        for (int i = 0; i < s.length(); i++) {



            char ch = s.charAt(i);



            if (ch == '(') {

                st.push(i);

            } 

            else if (ch == ')') {

                if (st.isEmpty()) {

                    rem[i] = 1;

                } else {

                    st.pop();

                }

            }

        }



        // Mark remaining unmatched '('

        while (!st.isEmpty()) {

            rem[st.pop()] = 1;

        }



        // Build the final valid string

        StringBuilder sb = new StringBuilder();



        for (int i = 0; i < s.length(); i++) {

            if (rem[i] == 0) {

                sb.append(s.charAt(i));

            }

        }



        return sb.toString();

    }

}