class Solution {
        class pair {
        int r, c;
        pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<pair> q = new LinkedList<>();
        int freshCount = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new pair(i, j));
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        if (freshCount == 0) return 0;

        int minutes = 0;
        int[][] dirs = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};

        while (!q.isEmpty()) {
            int size = q.size();
            boolean rottedInThisMinute = false;

            for (int i = 0; i < size; i++) {
                pair curr = q.poll();

                for (int[] d : dirs) {
                    int nextR = curr.r + d[0];
                    int nextC = curr.c + d[1];

                    if (nextR >= 0 && nextR < m && nextC >= 0 && nextC < n && grid[nextR][nextC] == 1) {
                        grid[nextR][nextC] = 2; // Make it rotten
                        q.offer(new pair(nextR, nextC));
                        freshCount--;
                        rottedInThisMinute = true;
                    }
                }
            }
            if (rottedInThisMinute) minutes++;
        }

        return freshCount == 0 ? minutes : -1;
    }
}