class Solution {
    public int numIslands(char[][] grid) {
      int m = grid.length;
      int n = grid[0].length;
      boolean[][] vis = new boolean[m][n];
      int count = 0;
      for(int i = 0; i  < m; i ++){
        for(int j = 0; j < n; j++){
            if(!vis[i][j] && grid[i][j] == '1'){
                count++;
                dfs(i , j, grid , vis);
            }
        }
      }
        return count;
        
    }

    public void dfs(int r, int c, char[][] grid, boolean[][] vis) {

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
           grid[nr][nc] == '1'){

            dfs(nr, nc, grid, vis);
        }
    }
}
}