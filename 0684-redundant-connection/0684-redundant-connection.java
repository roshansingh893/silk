class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        //boolean[] vis = new boolean[edges.length];
        int n = edges.length;

List<List<Integer>> graph = new ArrayList<>();

for (int i = 0; i <= n; i++) {
    graph.add(new ArrayList<>());
}
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            boolean[] vis = new boolean[edges.length + 1];
            if(dfs(u , v ,vis , graph )){
                return e;
            }
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return new int[] {- 1 , - 1};
    }

   public boolean dfs(int node, int target, boolean[] vis , List<List<Integer>> graph){

    if(node == target)
        return true;

    vis[node] = true;

    for(int nei : graph.get(node)){

        if(!vis[nei]){

            if(dfs(nei, target, vis , graph))
                return true;
        }
    }

    return false;
}
}