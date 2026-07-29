class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
    Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(mat[i][j] == 1){
                    mat[i][j] = -1;
                } else {
                    q.offer(new int[]{i , j});
                }
            }
        }
int[][] dirs = {
    {1, 0},
    {0, 1},
    {-1, 0},
    {0, -1}
};
        while(!q.isEmpty()){
             int[] curr = q.poll();
             int i = curr[0];
             int j = curr[1];

            for(int[] d : dirs){
                int ni = i + d[0];
                int nj = j + d[1];

                if(ni >= 0 && nj >= 0 && ni < m && nj < n && mat[ni][nj] == -1){
                    mat[ni][nj] = mat[i][j] + 1;

                    q.offer(new int[]{ni , nj});
                }

            }
                
        }
        return mat;
    }
}