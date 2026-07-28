class Solution {
    int maxcount = 0;
    int count = 0;
    public int maxAreaOfIsland(int[][] grid) {
      int m = grid.length;
      int n = grid[0].length;
      boolean[][] vis = new boolean[m][n];
     // int count = 0;
      for(int i = 0; i  < m; i ++){
        for(int j = 0; j < n; j++){
            if(!vis[i][j] && grid[i][j] == 1){
                dfs(i , j, grid , vis );
                maxcount = Math.max(count , maxcount);
                count = 0;
                
            }
        }
      }
        return maxcount;
        
    }

    public void dfs(int r, int c, int[][] grid, boolean[][] vis ) {
    count++;
    vis[r][c] = true;

    int[][] dir = {
        {1,0},
        {-1,0},
        {0,1},
        {0,-1}
    };

    for(int[] d : dir){

        int nr = r + d[0];
        int nc = c + d[1];

        if(nr >= 0 &&
           nr < grid.length &&
           nc >= 0 &&
           nc < grid[0].length &&
           !vis[nr][nc] &&
           grid[nr][nc] == 1){

            dfs(nr, nc, grid, vis);
        }
    }
}
}