class Solution {

    class Pair {
        int x;
        int y;
        int dist;

        Pair(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b.dist, a.dist)
        );

        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            int dist = x * x + y * y;

            pq.offer(new Pair(x, y, dist));

            if (pq.size() > k) {
                pq.poll(); 
            }
        }

        int[][] ans = new int[k][2];

        for (int i = 0; i < k; i++) {
            Pair p = pq.poll();
            ans[i][0] = p.x;
            ans[i][1] = p.y;
        }

        return ans;
    }
}