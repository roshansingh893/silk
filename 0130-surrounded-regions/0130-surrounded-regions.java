class Solution {
    public void solve(char[][] board) {
        
      int n = board.length;
        int m = board[0].length;

        Queue<int[]> q = new LinkedList<>();

        // Step 1: Push all boundary 'O' into queue and mark as 'S'
        
        // Top & Bottom rows
        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O') {
                q.offer(new int[]{0, j});
                board[0][j] = 'S';
            }
            if (board[n - 1][j] == 'O') {
                q.offer(new int[]{n - 1, j});
                board[n - 1][j] = 'S';
            }
        }

        // Left & Right columns
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') {
                q.offer(new int[]{i, 0});
                board[i][0] = 'S';
            }
            if (board[i][m - 1] == 'O') {
                q.offer(new int[]{i, m - 1});
                board[i][m - 1] = 'S';
            }
        }

         int[][] dirs = {{1 , 0 } , {0 , 1} , { - 1 , 0} , { 0 , -1}};


         while(!q.isEmpty()){

             int[] curr = q.poll();
             int r = curr[0];
             int c = curr[1];
             for(int[] d : dirs){
                int nr = r + d[0];
                int nc = c + d[1];

                if(nr >= 0 && nr < n  && nc >= 0 && nc < m && board[nr][nc] == 'O' ){
                    q.offer(new int[]{nr , nc});
                    board[nr][nc] = 'S';
                } 

             }
         }

           for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X'; // trapped
                } else if (board[i][j] == 'S') {
                    board[i][j] = 'O'; // restore safe
                }
            }
        }


    }
}