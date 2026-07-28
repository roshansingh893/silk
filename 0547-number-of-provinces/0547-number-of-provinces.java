class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int count = 0;
        boolean[] vis = new boolean[n];
        for(int i =0; i<n; i++){
            if(!vis[i]){
                count++;
                dfs(isConnected , i , vis);
            }
        }
        return count;
    }

    public void dfs(int[][] isConnected , int curr , boolean[] vis){
        vis[curr] = true;

        for(int i = 0; i < isConnected.length; i++){
            if(isConnected[curr][i] == 1 && !vis[i]){
                vis[i] = true; 
                dfs(isConnected , curr , vis);
            }
        }

    }
}