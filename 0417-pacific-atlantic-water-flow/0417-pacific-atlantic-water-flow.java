class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] borderp = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            borderp[i][0] = true;
        }
        for (int j = 0; j < n; j++) {
            borderp[0][j] = true;
        }

        boolean[][] bordera = new boolean[m][n];
        for (int j = 0; j < n; j++) {
            bordera[m - 1][j] = true;
        }
        for (int i = 0; i < m; i++) {
            bordera[i][n - 1] = true;
        }

        borderp = bfs(heights, borderp);
        bordera = bfs(heights, bordera);

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (borderp[i][j] && bordera[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }

        return ans;
    }

    public boolean[][] bfs(int[][] heights, boolean[][] border) {
        int rows = heights.length;
        int cols = heights[0].length;

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (border[i][j]) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int i = current[0];
            int j = current[1];

            for (int[] dir : directions) {
                int nextI = i + dir[0];
                int nextJ = j + dir[1];

                if (nextI >= 0 && nextI < rows &&
                    nextJ >= 0 && nextJ < cols &&
                    !border[nextI][nextJ] &&
                    heights[nextI][nextJ] >= heights[i][j]) {

                    border[nextI][nextJ] = true;
                    q.offer(new int[]{nextI, nextJ});
                }
            }
        }

        return border;
    }
}