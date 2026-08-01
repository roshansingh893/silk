class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            graph.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        // NEW
        int[][] dist = new int[n][k + 2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

        pq.offer(new int[]{0, src, k + 1});
        dist[src][k + 1] = 0; // NEW

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int cost = curr[0];
            int node = curr[1];
            int flightsLeft = curr[2];

            if (node == dst) {
                return cost;
            }

            // NEW (stale state check)
            if (cost > dist[node][flightsLeft]) continue;

            if (flightsLeft == 0) continue;

            for (int[] nei : graph.get(node)) {

                int nextNode = nei[0];
                int price = nei[1];

                int newCost = cost + price;

                // NEW
                if (newCost < dist[nextNode][flightsLeft - 1]) {

                    dist[nextNode][flightsLeft - 1] = newCost;

                    pq.offer(new int[]{
                        newCost,
                        nextNode,
                        flightsLeft - 1
                    });
                }
            }
        }

        return -1;
    }
}