class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        for(int[] p : prerequisites) adj.get(p[1]).add(p[0]);
        int[] state = new int[numCourses];
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < numCourses; i++){
            if(state[i] == 0){
                if(dfs(adj , i , state , st)) return new int[0]; 
            }
        }
        int[] res = new int[numCourses];
        int i = 0;
        while(!st.isEmpty()) {
            res[i++] = st.pop();
        }

        return res;

    }
    public boolean dfs(List<List<Integer>> adj , int node , int[] state , Stack<Integer> st){
        state[node] = 1; // i am visiting the node 
        for(int nei : adj.get(node)){
            if(state[nei] == 0){
                if(dfs(adj , nei , state , st)) return true;
            }  else if (state[nei] == 1){
                return true;
            }
        }
        state[node] = 2;
        st.push(node);
        return false;
    }
}